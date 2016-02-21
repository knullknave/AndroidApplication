package org.dani.medicbook.controller;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.dani.medicbook.LoginActivity;
import org.dani.medicbook.R;
import org.dani.medicbook.RegisterMedicActivity;
import org.dani.medicbook.base.Medic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ThreadAddMedic extends AsyncTask<URL, Integer, Long>
{
    private RegisterMedicActivity rma;
    private String url;
    public Medic[] m;
    public String user;
    public String urlFull;
    public ControllerMedicRegister cmr;
    public boolean sw;

    public ThreadAddMedic(RegisterMedicActivity rma, String urlFull, String url, String user, ControllerMedicRegister cmr)
    {
        this.rma = rma;
        this.user = user;
        this.url = url;
        this.cmr = cmr;
        this.urlFull = urlFull;
        this.sw = false;
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
        for (int i = 0; i < m.length; i++)
        {
            if (user.equals(m[i].getUsername()))
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

        if (sw == false)
        {
            if (insert2(urlFull))
            {
                rma.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(rma, rma.getResources().getString(R.string.successful), Toast.LENGTH_LONG).show();
                    }
                });
                rma.finish();
            }
            else
            {
                rma.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(rma, rma.getResources().getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        else
        {
            rma.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    Toast.makeText(rma, rma.getResources().getString(R.string.thisuseralreadyexists), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return null;
    }
}
