package org.dani.medicbook.controller;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.Toast;

import org.dani.medicbook.ConsultsMedicActivity;
import org.dani.medicbook.R;
import org.dani.medicbook.base.Patient;
import org.dani.medicbook.base.Visit;
import org.dani.medicbook.base.VisitasMedico;
import org.dani.medicbook.database.DataBaseManager;
import org.dani.medicbook.database.DataBaseManager2;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

public class ThreadGetList1  extends AsyncTask<URL, Integer, Long>
{
    public ConsultsMedicActivity cma;
    public int id;
    public Patient[] p;
    public Visit[] v;
    public int sw;

    public ThreadGetList1(ConsultsMedicActivity cma, int id)
    {
        this.cma = cma;
        this.id = id;
        sw = 0;
    }

    public ThreadGetList1(ConsultsMedicActivity cma, int idVisita, int sw)
    {
        this.cma = cma;
        this.id = idVisita;

        this.sw = 1;
    }

    public void search(String url)
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.p = restTemplate.getForObject(url, Patient[].class);
    }

    public void search2(String url)
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.v = restTemplate.getForObject(url, Visit[].class);
    }

    public boolean delete(String url)
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
            DataBaseManager2 manager2 = new DataBaseManager2(cma.getActivity());
            Cursor cursor2 = manager2.cargarCursor();
            cursor2.moveToLast();
            String SERVER_URL = cursor2.getString(0);

            search(String.valueOf(SERVER_URL + "/pacientes"));
            search2(String.valueOf(SERVER_URL + "/visitas"));

            for(int i=0; i< v.length; i++)
            {
                for(int j=0; j<p.length; j++)
                {
                    if(v[i].getIdmedic() == id && p[j].getId() == v[i].getIdpatient())
                    {
                        VisitasMedico vm = new VisitasMedico(v[i].getId(),p[j].getName() + ", " + p[j].getSurname(), p[j].getId(), id, v[i].getVisitDate());
                        DataBaseManager manager = new DataBaseManager(cma.getActivity());
                        int idF = p[j].getIdFoto();

                        Cursor cursor = manager.cargarCursorFotos();
                        if(cursor.getCount() >= idF)
                        {
                            cursor.moveToFirst();
                            do
                            {
                                if(cursor.getInt(0) == idF)
                                {
                                    break;
                                }
                            }
                            while(cursor.moveToNext());


                            //cursor.moveToFirst();
                            byte[] bArray = cursor.getBlob(1);
                            Bitmap background = BitmapFactory.decodeByteArray(bArray, 0, bArray.length);
                            vm.setFoto(background);
                        }

                        cma.listado.add(vm);
                    }
                }
            }

            cma.getActivity().runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    cma.listar();
                }
            });
        }
        else
        {
            DataBaseManager2 manager2 = new DataBaseManager2(cma.getActivity());
            Cursor cursor2 = manager2.cargarCursor();
            cursor2.moveToLast();
            String SERVER_URL = cursor2.getString(0);

            if(delete(SERVER_URL + "/delete_visit?id=" + id) == true)
            {
                cma.getActivity().runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(cma.getActivity(), cma.getActivity().getResources().getString(R.string.successful), Toast.LENGTH_LONG).show();
                    }
                });
            }
            else
            {
                cma.getActivity().runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(cma.getActivity(), cma.getActivity().getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
                    }
                });
            }
        }

        return null;
    }
}
