package com.android.dani.medicbook.controller;

import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.dani.medicbook.R;
import com.android.dani.medicbook.RegisterMedicActivity;

import static com.android.dani.medicbook.model.Constants.RESULTADO_CARGAR_IMAGEN;

public class ControllerMedicRegister implements View.OnClickListener
{
    private RegisterMedicActivity rma;
    private Button btAccept;
    private Button btCancel;
    private EditText etUser;
    private EditText etPassword;
    private EditText etName;
    private EditText etSurname;
    private EditText etPhone;
    private EditText etAddress;
    private EditText etEmail;
    private EditText etMedSpec;
    private EditText etPostalCode;
    private EditText etBirthDate;
    private EditText etMedicCentre;
    public ImageButton imageButton;

    public ControllerMedicRegister(RegisterMedicActivity rma)
    {
        this.rma = rma;

        this.btAccept = (Button) rma.findViewById(R.id.btAccept);
        btAccept.setOnClickListener(this);
        this.btCancel = (Button) rma.findViewById(R.id.btCancel);
        btCancel.setOnClickListener(this);

        etUser = (EditText) rma.findViewById(R.id.etUser);
        etUser.setOnClickListener(this);
        etPassword = (EditText) rma.findViewById(R.id.etPassword);
        etPassword.setOnClickListener(this);
        etName = (EditText) rma.findViewById(R.id.etName);
        etName.setOnClickListener(this);
        etSurname = (EditText) rma.findViewById(R.id.etSurname);
        etSurname.setOnClickListener(this);
        etPhone = (EditText) rma.findViewById(R.id.etPhone);
        etPhone.setOnClickListener(this);
        etAddress = (EditText) rma.findViewById(R.id.etAddress);
        etAddress.setOnClickListener(this);
        etEmail = (EditText) rma.findViewById(R.id.etEmail);
        etEmail.setOnClickListener(this);
        etMedSpec = (EditText) rma.findViewById(R.id.etMedSpec);
        etMedSpec.setOnClickListener(this);
        etPostalCode = (EditText) rma.findViewById(R.id.etPostalCode);
        etPostalCode.setOnClickListener(this);
        etBirthDate = (EditText) rma.findViewById(R.id.etBirthDate);
        etBirthDate.setOnClickListener(this);
        etMedicCentre = (EditText) rma.findViewById(R.id.etMedicCentre);
        etMedicCentre.setOnClickListener(this);
        imageButton = (ImageButton) rma.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this);
    }

    public void setValues(boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, boolean b6, boolean b7, boolean b8, boolean b9, boolean b10, boolean b11)
    {
        if(etUser.getText().toString().trim().equals(""))
            etUser.setText(rma.getResources().getString(R.string.user));
        if(etPassword.getText().toString().trim().equals(""))
            etPassword.setText(rma.getResources().getString(R.string.password));
        if(etName.getText().toString().trim().equals(""))
            etName.setText(rma.getResources().getString(R.string.name));
        if(etSurname.getText().toString().trim().equals(""))
            etSurname.setText(rma.getResources().getString(R.string.surname));
        if(etPhone.getText().toString().trim().equals(""))
            etPhone.setText(rma.getResources().getString(R.string.phone));
        if(etAddress.getText().toString().trim().equals(""))
            etAddress.setText(rma.getResources().getString(R.string.address));
        if(etEmail.getText().toString().trim().equals(""))
            etEmail.setText(rma.getResources().getString(R.string.email));
        if(etMedSpec.getText().toString().trim().equals(""))
            etMedSpec.setText(rma.getResources().getString(R.string.medSpeciality));
        if(etPostalCode.getText().toString().trim().equals(""))
            etPostalCode.setText(rma.getResources().getString(R.string.postalcode));
        if(etBirthDate.getText().toString().trim().equals(""))
            etBirthDate.setText(rma.getResources().getString(R.string.birthdate));
        if(etMedicCentre.getText().toString().trim().equals(""))
            etMedicCentre.setText(rma.getResources().getString(R.string.medicalcentre));

        if(etUser.getText().toString().trim().equals(rma.getResources().getString(R.string.user)) && b1 == true)
            etUser.setText("");
        if(etPassword.getText().toString().trim().equals(rma.getResources().getString(R.string.password)) && b2 == true)
            etPassword.setText("");
        if(etName.getText().toString().trim().equals(rma.getResources().getString(R.string.name)) && b3 == true)
            etName.setText("");
        if(etSurname.getText().toString().trim().equals(rma.getResources().getString(R.string.surname)) && b4 == true)
            etSurname.setText("");
        if(etPhone.getText().toString().trim().equals(rma.getResources().getString(R.string.phone)) && b5 == true)
            etPhone.setText("");
        if(etAddress.getText().toString().trim().equals(rma.getResources().getString(R.string.address)) && b6 == true)
            etAddress.setText("");
        if(etEmail.getText().toString().trim().equals(rma.getResources().getString(R.string.email)) && b7 == true)
            etEmail.setText("");
        if(etMedSpec.getText().toString().trim().equals(rma.getResources().getString(R.string.medSpeciality)) && b8 == true)
            etMedSpec.setText("");
        if(etPostalCode.getText().toString().trim().equals(rma.getResources().getString(R.string.postalcode)) && b9 == true)
            etPostalCode.setText("");
        if(etBirthDate.getText().toString().trim().equals(rma.getResources().getString(R.string.birthdate)) && b10 == true)
            etBirthDate.setText("");
        if(etMedicCentre.getText().toString().trim().equals(rma.getResources().getString(R.string.medicalcentre)) && b11 == true)
            etMedicCentre.setText("");
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btAccept:
                //TODO METER A LA BASE DE DATOS Y VOLVER A LOGIN
                break;
            case R.id.btCancel:
                rma.finish();
                break;
            case R.id.etUser:
                setValues(true, false, false, false, false, false, false, false, false, false, false);
                break;
            case R.id.etPassword:
                setValues(false, true, false, false, false, false, false, false, false, false, false);
                break;
            case R.id.etName:
                setValues(false, false, true, false, false, false, false, false, false, false, false);
                break;
            case R.id.etSurname:
                setValues(false, false, false, true, false, false, false, false, false, false, false);
                break;
            case R.id.etPhone:
                setValues(false, false, false, false, true, false, false, false, false, false, false);
                break;
            case R.id.etAddress:
                setValues(false, false, false, false, false, true, false, false, false, false, false);
                break;
            case R.id.etEmail:
                setValues(false, false, false, false, false, false, true, false, false, false, false);
                break;
            case R.id.etMedSpec:
                setValues(false, false, false, false, false, false, false, true, false, false, false);
                break;
            case R.id.etPostalCode:
                setValues(false, false, false, false, false, false, false, false, true, false, false);
                break;
            case R.id.etBirthDate:
                setValues(false, false, false, false, false, false, false, false, false, true, false);
                break;
            case R.id.etMedicCentre:
                setValues(false, false, false, false, false, false, false, false, false, false, true);
                break;
            case R.id.imageButton:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                rma.startActivityForResult(intent, RESULTADO_CARGAR_IMAGEN);
                //TODO PENSAR COMO GUARDARLA (DE MANERA QUE JUEGUES CON SQLITE)
                break;
        }
    }
}