package org.dani.medicbook.controller;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.dani.medicbook.R;
import org.dani.medicbook.RegisterMedicActivity;

import org.dani.medicbook.database.DataBaseManager;
import org.dani.medicbook.database.DataBaseManager2;
import org.dani.medicbook.model.Constants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ControllerMedicRegister implements View.OnClickListener
{
    public RegisterMedicActivity rma;
    public Button btAccept;
    public Button btCancel;
    public EditText etUser;
    public EditText etPassword;
    public EditText etName;
    public EditText etSurname;
    public EditText etPhone;
    public EditText etAddress;
    public EditText etEmail;
    public EditText etMedSpec;
    public EditText etMedicCentre;
    public ImageButton imageButton;
    public String url;
    public int sw;

    public ControllerMedicRegister(RegisterMedicActivity rma)
    {
        this.rma = rma;
        sw = 0;

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
        if(etMedicCentre.getText().toString().trim().equals(rma.getResources().getString(R.string.medicalcentre)) && b11 == true)
            etMedicCentre.setText("");
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btAccept:

                DataBaseManager manager = new DataBaseManager(rma);
                manager.insertar(rma.image, "Medico");
                Cursor cursor = manager.cargarCursorFotos();

                cursor.moveToLast();

                int id = Integer.valueOf(cursor.getString(0));

                url = "/add_medic?username=" + etUser.getText().toString().trim() + "&userpassword=" + etPassword.getText().toString().trim() + "&name=" + etName.getText().toString().trim() + "&surname=" +
                        etSurname.getText().toString().trim() + "&adress=" + etAddress.getText().toString().trim() + "&medicalcentre=" + etMedicCentre.getText().toString().trim() + "&email=" +
                        etEmail.getText().toString().trim() + "&medicalspeciality=" + etMedSpec.getText().toString().trim() + "&telephone=" + etPhone.getText().toString().trim() + "&idfoto=" + id;
                DataBaseManager2 manager2 = new DataBaseManager2(rma);
                Cursor cursor2 = manager2.cargarCursor();
                cursor2.moveToLast();
                String SERVER_URL = cursor2.getString(0);
                String urlFull = SERVER_URL + url;

                ThreadAddMedic test = new ThreadAddMedic(rma, urlFull, SERVER_URL + "/medicos", etUser.getText().toString(), this);
                test.execute();

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
            case R.id.etBirthDate:
                setValues(false, false, false, false, false, false, false, false, false, true, false);
                break;
            case R.id.etMedicCentre:
                setValues(false, false, false, false, false, false, false, false, false, false, true);
                break;
            case R.id.imageButton:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                rma.startActivityForResult(intent, Constants.RESULTADO_CARGAR_IMAGEN);
                break;
        }
    }
}