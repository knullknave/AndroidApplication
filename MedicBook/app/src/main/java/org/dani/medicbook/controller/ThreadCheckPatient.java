package org.dani.medicbook.controller;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.Toast;

import org.dani.medicbook.LoginActivity;
import org.dani.medicbook.MainFragmentPatientActivity;
import org.dani.medicbook.R;
import org.dani.medicbook.base.Patient;
import org.dani.medicbook.database.DataBaseManager2;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

public class ThreadCheckPatient extends AsyncTask<URL, Integer, Long>
{
    private ControllerLogin cl;
    private LoginActivity la;
    private String user;
    private String pass;
    private Patient[] p;
    private boolean sw;
    public int i;

    public ThreadCheckPatient(ControllerLogin cl, LoginActivity la, String user, String pass)
    {
        this.cl = cl;
        this.la = la;
        this.user = user;
        this.pass = pass;
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
        for (i = 0; i < p.length; i++)
        {
            if (user.equals(p[i].getUsername()) && pass.equals(p[i].getPas()))
                return true;
        }
        return false;
    }

    @Override
    protected Long doInBackground(URL... params)
    {
        DataBaseManager2 manager2 = new DataBaseManager2(la);
        Cursor cursor2 = manager2.cargarCursor();
        cursor2.moveToLast();
        String SERVER_URL = cursor2.getString(0);

        insert3(SERVER_URL + "/pacientes");
        sw = search();

        if(sw == true)
        {
            la.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    Toast.makeText(la, la.getResources().getString(R.string.successful), Toast.LENGTH_SHORT).show();
                }
            });

            Intent intent = new Intent(la, MainFragmentPatientActivity.class);
            intent.putExtra("Paciente", p[i].getId());
            la.startActivity(intent);
        }
        else
        {
            la.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    Toast.makeText(la, la.getResources().getString(R.string.userandpassworng), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return null;
    }
}
