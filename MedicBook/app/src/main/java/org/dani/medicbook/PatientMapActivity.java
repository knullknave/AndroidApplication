package org.dani.medicbook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import org.dani.medicbook.controller.ThreadMedicMap;
import org.dani.medicbook.controller.ThreadPatientMap;

public class PatientMapActivity extends ActionBarActivity  implements GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener
{
    public GoogleMap map;
    ThreadPatientMap tpm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_patient_map);

        try
        {
            MapsInitializer.initialize(this);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        //map.setMyLocationEnabled(true);

        CameraUpdate camara = CameraUpdateFactory.newLatLng(new LatLng(41.6561, -0.8773));

        // Coloca la vista del mapa sobre la posición del restaurante
        // y activa el zoom para verlo de cerca
        map.moveCamera(camara);
        map.animateCamera(CameraUpdateFactory.zoomTo(7.0f));

        map.setOnInfoWindowClickListener(this);
        //map.setOnMarkerClickListener(this);

        ubicarHospitales();
    }

    public void ubicarHospitales()
    {
        //TODO Acercar vista y posicionar en un punto
        //41.644780, -0.895047

        tpm = new ThreadPatientMap(this);
        tpm.execute();
    }

    @Override
    public void onInfoWindowClick(Marker marker)
    {
        String nombre = marker.getTitle();

        Uri dato = Uri.parse("1");

        Intent resultado = new Intent(null, dato);
        resultado.putExtra("CentroMedico", nombre);
        setResult(RESULT_OK, resultado);
        this.finish();
    }

    @Override
    public boolean onMarkerClick(Marker marker)
    {
        return false;
    }
}
