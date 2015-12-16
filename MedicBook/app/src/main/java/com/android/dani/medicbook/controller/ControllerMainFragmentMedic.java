package com.android.dani.medicbook.controller;

import android.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.dani.medicbook.MainFragmentMedicActivity;
import com.android.dani.medicbook.NewConsultMedicActivity;
import com.android.dani.medicbook.R;

public class ControllerMainFragmentMedic implements View.OnClickListener, AdapterView.OnItemSelectedListener
{
    private MainFragmentMedicActivity mfma;
    private Spinner spinner;
    Fragment ncm;

    public ControllerMainFragmentMedic(MainFragmentMedicActivity mfma)
    {
        this.mfma = mfma;

        ncm = mfma.getFragmentManager().findFragmentById(R.id.newconsultMedic);



        String[] datos = new String[]{mfma.getResources().getString(R.string.whoareyou), mfma.getResources().getString(R.string.patient),mfma.getResources().getString(R.string.medic)};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(mfma , android.R.layout.simple_spinner_item, datos);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View v)
    {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
