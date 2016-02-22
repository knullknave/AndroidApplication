package org.dani.medicbook.controller;

import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.dani.medicbook.NewConsultPatientActivity;
import org.dani.medicbook.R;
import org.dani.medicbook.base.Medic;
import org.dani.medicbook.database.DataBaseManager2;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

public class ThreadAddVisitPatient extends AsyncTask<URL, Integer, Long>
{
    private NewConsultPatientActivity ncpa;
    private int id;
    private Spinner spinner;
    private int sw;
    private Medic[] m;

    private String date, centre;
    private int idMedic;

    public ThreadAddVisitPatient(NewConsultPatientActivity ncpa, int id)
    {
        this.ncpa = ncpa;
        this.id = id;
        sw = 0;

        spinner = (Spinner) ncpa.rootView.findViewById(R.id.spinnerMedicos);
    }

    public ThreadAddVisitPatient(NewConsultPatientActivity ncpa, int id, String date, String centre, int idMedic)
    {
        this.ncpa = ncpa;
        this.id = id;
        sw = 1;

        spinner = (Spinner) ncpa.rootView.findViewById(R.id.spinnerMedicos);

        this.date = date;
        this.centre = centre;
        this.idMedic = idMedic;
    }

    public void getPatients(String url)
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.m =  restTemplate.getForObject(url, Medic[].class);
    }

    public void loadMedics()
    {
        ArrayAdapter<Medic> adaptador = new ArrayAdapter<Medic>(ncpa.getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, this.m);
        spinner.setAdapter(adaptador);
    }

    public boolean storeVisit(String url)
    {
        try
        {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            restTemplate.getForObject(url, Void.class);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected Long doInBackground(URL... params)
    {
        if(sw == 0)
        {
            DataBaseManager2 manager2 = new DataBaseManager2(ncpa.getActivity());
            Cursor cursor2 = manager2.cargarCursor();
            cursor2.moveToLast();
            String SERVER_URL = cursor2.getString(0);

            getPatients(SERVER_URL + "/medicos");
            ncpa.getActivity().runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    loadMedics();
                }
            });
        }
        else
        {
            DataBaseManager2 manager2 = new DataBaseManager2(ncpa.getActivity());
            Cursor cursor2 = manager2.cargarCursor();
            cursor2.moveToLast();
            String SERVER_URL = cursor2.getString(0);

            if(storeVisit(SERVER_URL + "/add_visit?medicalcentre=" + centre + "&visitdate=" + date + "&idMedic=" + idMedic + "&idPatient=" + id))
            {
                ncpa.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ncpa.getActivity(), ncpa.getActivity().getResources().getString(R.string.successful), Toast.LENGTH_LONG).show();
                    }
                });
            }
            else
            {
                ncpa.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ncpa.getActivity(), ncpa.getActivity().getResources().getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        return null;
    }
}
