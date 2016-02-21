package org.dani.medicbook.controller;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.dani.medicbook.LoginActivity;
import org.dani.medicbook.MainFragmentMedicActivity;
import org.dani.medicbook.R;
import org.dani.medicbook.base.Medic;
import org.dani.medicbook.database.DataBaseManager2;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

/**
 * Created by Daniel on 08/01/2016.
 */
public class ThreadCheckMedic extends AsyncTask<URL, Integer, Long>
{
    private ControllerLogin cl;
    private LoginActivity la;
    private String user;
    private String pass;
    private Medic[] m;
    private boolean sw;
    public int i;

    public ThreadCheckMedic(ControllerLogin cl, LoginActivity la, String user, String pass)
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
            this.m = restTemplate.getForObject(url, Medic[].class);
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
        for (i = 0; i < m.length; i++)
        {
            if (user.equals(m[i].getUsername()) && pass.equals(m[i].getPas()))
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
        insert3(SERVER_URL + "/medicos");
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

            Intent intent = new Intent(la, MainFragmentMedicActivity.class);
            intent.putExtra("Medico", m[i].getId());
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
