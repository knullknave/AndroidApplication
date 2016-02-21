package org.dani.medicbook.controller;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.dani.medicbook.PatientMapActivity;
import org.dani.medicbook.base.Centro;
import org.dani.medicbook.database.DataBaseManager2;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ThreadPatientMap extends AsyncTask<URL, Integer, Long>
{

    public Centro[] centro;
    PatientMapActivity pma;
    public ArrayList<Marker> listaMarkers;

    public ThreadPatientMap(PatientMapActivity pma)
    {
        this.pma = pma;

        listaMarkers = new ArrayList<Marker>();
    }

    public boolean getCentros(String url)
    {
        try
        {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            this.centro = restTemplate.getForObject(url, Centro[].class);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public Bitmap getImages(int i)
    {
        try
        {
            URL url = new URL(centro[i].getIcon());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected Long doInBackground(URL... params)
    {
        DataBaseManager2 manager2 = new DataBaseManager2(pma);
        Cursor cursor2 = manager2.cargarCursor();
        cursor2.moveToLast();
        String SERVER_URL = cursor2.getString(0);

        getCentros(SERVER_URL + "/centros");

        final Bitmap imagen = getImages(0);

        pma.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < centro.length; i++)
                {
                    listaMarkers.add(pma.map.addMarker(new MarkerOptions().position(new LatLng(centro[i].getPositionx(), centro[i].getPositiony())).title(centro[i].getName()).icon(BitmapDescriptorFactory.fromBitmap(imagen))));
                    listaMarkers.get(i);
                }
            }
        });
        return null;
    }
}
