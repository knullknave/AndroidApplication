package org.dani.medicbook.controller;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.dani.medicbook.NewConsultMedicActivity;
import org.dani.medicbook.R;
import org.dani.medicbook.base.Medic;
import org.dani.medicbook.base.Patient;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.Date;

public class ThreadAddVisitMedic extends AsyncTask<URL, Integer, Long>
{
    private NewConsultMedicActivity ncma;
    private int id;
    private Spinner spinner;
    private int sw;
    private Patient[] p;

    private String date;
    private String centre;
    private int idPatient;

    public ThreadAddVisitMedic(NewConsultMedicActivity ncma, int id)
    {
        this.ncma = ncma;
        this.id = id;
        sw = 0;

        spinner = (Spinner) ncma.rootView.findViewById(R.id.spinner3);
    }

    public ThreadAddVisitMedic(NewConsultMedicActivity ncma, int id, String visit, String centre, int idPatient)
    {
        this.ncma = ncma;
        this.id = id;
        sw = 1;

        spinner = (Spinner) ncma.rootView.findViewById(R.id.spinner3);

        this.date = visit;
        this.centre = centre;
        this.idPatient = idPatient;
    }

    public void getPatients(String url)
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this. p =  restTemplate.getForObject(url, Patient[].class);
    }

    public void loadPatients()
    {
        ArrayAdapter<Patient> adaptador = new ArrayAdapter<Patient>(ncma.getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, this.p);
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
            getPatients("http://192.168.2.6:8080/pacientes");
            ncma.getActivity().runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    loadPatients();
                }
            });
        }
        else
        {
            if(storeVisit("http://192.168.2.6:8080/add_visit?medicalcentre=" + centre + "&visitdate=" + date + "&idMedic=" + id + "&idPatient=" + idPatient))
            {
                ncma.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ncma.getActivity(), ncma.getActivity().getResources().getString(R.string.successful), Toast.LENGTH_LONG).show();
                    }
                });
            }
            else
            {
                ncma.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ncma.getActivity(), ncma.getActivity().getResources().getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        return null;
    }
}