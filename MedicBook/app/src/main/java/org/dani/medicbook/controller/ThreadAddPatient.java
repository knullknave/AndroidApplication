package org.dani.medicbook.controller;

import android.os.AsyncTask;
import android.widget.Toast;

import org.dani.medicbook.R;
import org.dani.medicbook.RegisterPatientActivity;
import org.dani.medicbook.base.Patient;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

/**
 * Created by Daniel on 08/01/2016.
 */
public class ThreadAddPatient extends AsyncTask<URL, Integer, Long>
{
    public RegisterPatientActivity rpa;
    public String urlFull;
    public String url;
    public String user;
    public ControllerPatientRegister cpr;
    public Patient[] p;
    public boolean sw;

    public ThreadAddPatient(RegisterPatientActivity rpa, String urlFull, String url, String user, ControllerPatientRegister cpr)
    {
        this.rpa = rpa;
        this.url = url;
        this.urlFull = urlFull;
        this.user = user;
        this.cpr = cpr;
    }

    public boolean insert2(String url)
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

    public boolean insert3(String url)
    {
        try
        {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            this.p = restTemplate.getForObject(url, Patient[].class);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean search()
    {
        for (int i = 0; i < p.length; i++)
        {
            if (user.equals(p[i].getUsername()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    protected Long doInBackground(URL... params)
    {
        insert3(url);
        sw = search();

        if(sw == false)
        {
            if(insert2(urlFull))
            {
                rpa.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(rpa, rpa.getResources().getString(R.string.successful), Toast.LENGTH_LONG).show();
                    }
                });
                rpa.finish();
            }
            else
            {
                rpa.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(rpa, rpa.getResources().getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        else
        {
            rpa.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    Toast.makeText(rpa, rpa.getResources().getString(R.string.thisuseralreadyexists), Toast.LENGTH_SHORT).show();
                }
            });
        }

        return null;
    }
}
