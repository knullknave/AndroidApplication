package com.android.dani.medicbook.controller;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.dani.medicbook.LoginActivity;
import com.android.dani.medicbook.R;
import com.android.dani.medicbook.RegisterMedicActivity;
import com.android.dani.medicbook.RegisterPatientActivity;

public class ControllerLogin implements View.OnClickListener, AdapterView.OnItemSelectedListener
{
    private LoginActivity la;
    private EditText etUser;
    private EditText etPassword;
    private String info1;
    private String info2;
    private Spinner spinner;
    private String posSpinner;

    public ControllerLogin(LoginActivity la)
    {
        this.la = la;

        Button btnRM = (Button) la.findViewById(R.id.btnRegisterMedic);
        btnRM.setOnClickListener(this);

        Button btnRP = (Button) la.findViewById(R.id.btnRegisterPatient);
        btnRP.setOnClickListener(this);

        etUser = (EditText) la.findViewById(R.id.etUser);
        etUser.setOnClickListener(this);
        etPassword = (EditText) la.findViewById(R.id.etPassword);
        etPassword.setOnClickListener(this);

        info1 = etUser.getText().toString();
        info2 = etPassword.getText().toString();

        spinner = (Spinner) la.findViewById(R.id.spinner);

        String[] datos = new String[]{la.getResources().getString(R.string.whoareyou), la.getResources().getString(R.string.patient),la.getResources().getString(R.string.medic)};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(la, android.R.layout.simple_spinner_item, datos);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnLogin:
                if(posSpinner.equals(la.getResources().getString(R.string.whoareyou)))
                {
                    //TODO ERROR
                }
                else
                {
                    if(etUser.getText().toString().trim().equals("") || etPassword.getText().toString().trim().equals(""))
                    {
                        //TODO PLEASE FILL EACH FIELD
                    }
                    else
                    {
                        //TODO LOGIN
                    }
                }
                break;
            case R.id.btnRegisterMedic:
                Intent intent2 = new Intent(la, RegisterMedicActivity.class);
                la.startActivity(intent2);
                break;
            case R.id.btnRegisterPatient:
                Intent intent3 = new Intent(la, RegisterPatientActivity.class);
                la.startActivity(intent3);
                break;
            case R.id.etUser:
                if(etPassword.getText().toString().trim().equals(""))
                    etPassword.setText(info2);
                if(etUser.getText().toString().trim().equals(info1))
                    etUser.setText("");
                break;
            case R.id.etPassword:
                if(etUser.getText().toString().trim().equals(""))
                    etUser.setText(info1);
                if(etPassword.getText().toString().trim().equals(info2))
                    etPassword.setText("");
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch (parent.getId())
        {
            case R.id.spinner:
                posSpinner = (String) parent.getItemAtPosition(position);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        //NOTHING
    }
}