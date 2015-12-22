package org.dani.medicbook.controller;

import android.content.ContentValues;
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

/**
 * Created by Daniel on 20/12/2015.
 */
public class RunTest extends AsyncTask<URL, Integer, Long>
{
    ControllerMedicRegister  cmr;
    RegisterMedicActivity rma;

    public RunTest(ControllerMedicRegister cmr, RegisterMedicActivity rma)
    {
        this.cmr = cmr;
        this.rma = rma;
    }

    @Deprecated
    public boolean insert()
    {
        HttpClient httpClient;
        List<NameValuePair> nameValuePairs;
        HttpPost httpPost;

        httpClient = new DefaultHttpClient();
        httpPost = new HttpPost("http://10.0.2.2:8080/add_medic");
        nameValuePairs = new ArrayList<NameValuePair>(9);
        nameValuePairs.add(new BasicNameValuePair("userName", "aaaaa"));
        nameValuePairs.add(new BasicNameValuePair("userPassword", "aaaaa"));
        nameValuePairs.add(new BasicNameValuePair("name", "aaaaa"));
        nameValuePairs.add(new BasicNameValuePair("surname", "aaaaa"));
        nameValuePairs.add(new BasicNameValuePair("adress", "aaaaa"));
        nameValuePairs.add(new BasicNameValuePair("medicalCentre", "aaaaa"));
        nameValuePairs.add(new BasicNameValuePair("email", "aaaaa"));
        nameValuePairs.add(new BasicNameValuePair("medicalSpeciality", "aaaaa"));
        nameValuePairs.add(new BasicNameValuePair("telephone", "aaaaa"));

        try
        {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            httpPost.getParams();

            httpClient.execute(httpPost);

            return true;
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return false;
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

    @Override
    protected Long doInBackground(URL... params)
    {
        if(insert2("http://192.168.2.6:8080/add_medic?username=a&userpassword=a&name=a&surname=a&adress=a&medicalcentre=a&email=a&medicalspeciality=a&telephone=a"))
        {
            rma.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    Toast.makeText(rma, "Exito", Toast.LENGTH_LONG).show();
                }
            });
        }
        else
        {
            rma.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    Toast.makeText(rma, "Error", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return null;
    }
}
