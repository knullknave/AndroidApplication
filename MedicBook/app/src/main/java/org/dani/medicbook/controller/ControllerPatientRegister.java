package org.dani.medicbook.controller;

import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.dani.medicbook.R;
import org.dani.medicbook.RegisterPatientActivity;
import org.dani.medicbook.database.DataBaseManager;
import org.dani.medicbook.model.Constants;

public class ControllerPatientRegister implements View.OnClickListener
{
    private RegisterPatientActivity rpa;
    private Button btAccept;
    private Button btCancel;
    private EditText etUser;
    private EditText etPassword;
    private EditText etName;
    private EditText etSurname;
    private EditText etPhone;
    private EditText etAddress;
    //TODO CONJUNTO DE RADIO BUTTON
    private EditText etBirthDate;
    public ImageButton imageButton;
    public RadioButton rdbOne;
    public RadioButton rdbTwo;
    public String url;

    public ControllerPatientRegister(RegisterPatientActivity rpa)
    {
        this.rpa = rpa;

        btAccept = (Button) rpa.findViewById(R.id.btAccept);
        btAccept.setOnClickListener(this);
        btCancel = (Button) rpa.findViewById(R.id.btCancel);
        btCancel.setOnClickListener(this);

        etUser = (EditText) rpa.findViewById(R.id.etUser);
        etUser.setOnClickListener(this);
        etPassword = (EditText) rpa.findViewById(R.id.etPassword);
        etPassword.setOnClickListener(this);
        etName = (EditText) rpa.findViewById(R.id.etName);
        etName.setOnClickListener(this);
        etSurname = (EditText) rpa.findViewById(R.id.etSurname);
        etSurname.setOnClickListener(this);
        etPhone = (EditText) rpa.findViewById(R.id.etPhone);
        etPhone.setOnClickListener(this);
        etAddress = (EditText) rpa.findViewById(R.id.etAddress);
        etAddress.setOnClickListener(this);
        rdbOne = (RadioButton) rpa.findViewById(R.id.rdbOne);
        rdbTwo = (RadioButton) rpa.findViewById(R.id.rdbTwo);
        etBirthDate = (EditText) rpa.findViewById(R.id.etBirthDate);
        etBirthDate.setOnClickListener(this);
        imageButton = (ImageButton) rpa.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this);
    }

    public void setValues(boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, boolean b6, boolean b7, boolean b8, boolean b9)
    {
        if(etUser.getText().toString().trim().equals(""))
            etUser.setText(rpa.getResources().getString(R.string.user));
        if(etPassword.getText().toString().trim().equals(""))
            etPassword.setText(rpa.getResources().getString(R.string.password));
        if(etName.getText().toString().trim().equals(""))
            etName.setText(rpa.getResources().getString(R.string.name));
        if(etSurname.getText().toString().trim().equals(""))
            etSurname.setText(rpa.getResources().getString(R.string.surname));
        if(etPhone.getText().toString().trim().equals(""))
            etPhone.setText(rpa.getResources().getString(R.string.phone));
        if(etAddress.getText().toString().trim().equals(""))
            etAddress.setText(rpa.getResources().getString(R.string.address));
        if(etBirthDate.getText().toString().trim().equals(""))
            etBirthDate.setText(rpa.getResources().getString(R.string.birthdate));

        if(etUser.getText().toString().trim().equals(rpa.getResources().getString(R.string.user)) && b1 == true)
            etUser.setText("");
        if(etPassword.getText().toString().trim().equals(rpa.getResources().getString(R.string.password)) && b2 == true)
            etPassword.setText("");
        if(etName.getText().toString().trim().equals(rpa.getResources().getString(R.string.name)) && b3 == true)
            etName.setText("");
        if(etSurname.getText().toString().trim().equals(rpa.getResources().getString(R.string.surname)) && b4 == true)
            etSurname.setText("");
        if(etPhone.getText().toString().trim().equals(rpa.getResources().getString(R.string.phone)) && b5 == true)
            etPhone.setText("");
        if(etAddress.getText().toString().trim().equals(rpa.getResources().getString(R.string.address)) && b6 == true)
            etAddress.setText("");
        if(etBirthDate.getText().toString().trim().equals(rpa.getResources().getString(R.string.birthdate)) && b9 == true)
            etBirthDate.setText("");;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btAccept:

                DataBaseManager manager = new DataBaseManager(rpa);
                manager.insertar(rpa.image, "Paciente");
                Cursor cursor = manager.cargarCursorFotos();

                cursor.moveToLast();

                int id = Integer.valueOf(cursor.getString(0));

                String sex;
                if(rdbOne.isChecked())
                    sex = "H";
                else
                    sex = "M";
                url = "/add_patient?username=" + etUser.getText().toString().trim() + "&userpassword=" + etPassword.getText().toString().trim() + "&name=" + etName.getText().toString().trim() + "&surname=" +
                        etSurname.getText().toString().trim() + "&sex=" + sex + "&adress=" + etAddress.getText().toString().trim() + "&birthdate="+ etBirthDate.getText().toString().trim() + "&telephone=" +
                        etPhone.getText().toString().trim() + "&idfoto=" + id;
                String SERVER_URL = "http://192.168.2.6:8080";
                String urlFull = SERVER_URL + url;

                ThreadAddPatient test = new ThreadAddPatient(rpa, urlFull, SERVER_URL + "/pacientes", etUser.getText().toString().trim(), this);
                test.execute();

                break;
            case R.id.btCancel:
                rpa.finish();
                break;
            case R.id.etUser:
                setValues(true, false, false, false, false, false, false, false, false);
                break;
            case R.id.etPassword:
                setValues(false, true, false, false, false, false, false, false, false);
                break;
            case R.id.etName:
                setValues(false, false, true, false, false, false, false, false, false);
                break;
            case R.id.etSurname:
                setValues(false, false, false, true, false, false, false, false, false);
                break;
            case R.id.etPhone:
                setValues(false, false, false, false, true, false, false, false, false);
                break;
            case R.id.etAddress:
                setValues(false, false, false, false, false, true, false, false, false);
                break;
            case R.id.etEmail:
                setValues(false, false, false, false, false, false, true, false, false);
                break;
            case R.id.etBirthDate:
                setValues(false, false, false, false, false, false, false, false, true);
                break;
            case R.id.imageButton:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                rpa.startActivityForResult(intent, Constants.RESULTADO_CARGAR_IMAGEN);
                break;
        }
    }
}