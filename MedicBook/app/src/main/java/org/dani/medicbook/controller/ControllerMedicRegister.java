package org.dani.medicbook.controller;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.dani.medicbook.R;
import org.dani.medicbook.RegisterMedicActivity;

import org.dani.medicbook.model.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.TooManyListenersException;

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
    public EditText etPostalCode;
    public EditText etBirthDate;
    public EditText etMedicCentre;
    public ImageButton imageButton;
    public String url;

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
        url = "http://192.168.2.6:8080/add_medic?userName="+etUser.getText()+"&userPassword="+etPassword.getText()+"&name="+etName.getText()+"&surname="+etSurname.getText()+"&adress="+etAddress.getText()+"&medicalCentre="+etMedicCentre.getText()+"&email="+etEmail.getText()+"&medicalSpeciality="+etMedSpec.getText()+"&telephone="+etPhone.getText();

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
                url = "/add_medic?userName=" + etUser.getText().toString().replace(" ", "_") + "&userPassword=" + etPassword.getText().toString().replace(" ", "_") + "&name=" + etName.getText().toString().replace(" ", "_") + "&surname=" + etSurname.getText().toString().replace(" ", "_") + "&adress=" + etAddress.getText().toString().replace(" ", "_") + "&medicalCentre=" + etMedicCentre.getText().toString().replace(" ", "_") + "&email=" + etEmail.getText().toString().replace(" ", "_") + "&medicalSpeciality=" + etMedSpec.getText().toString().replace(" ", "_") + "&telephone=" + etPhone.getText().toString().replace(" ", "_");
                String SERVER_URL = "http://10.0.2.2:8080";
                String urlFull = SERVER_URL + url;

                RunTest test = new RunTest(this, rma);
                test.execute();
                /*
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ContentValues values = new ContentValues();
                restTemplate.getForObject(SERVER_URL + url, Void.class);
                */


                /*
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.getForEntity("https://data.sparkfun.com/streams/dZ4EVmE8yGCRGx5XRX1W.json", String.class);

                if (HttpStatus.OK == response.getStatusCode())
                {
                    System.out.println(response);
                }
                else
                {
                    // log error, retry or ?
                }
                */
                //Toast.makeText(rma, response.toString(), Toast.LENGTH_LONG);

                /*
                HttpClient clienteHttp = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(urlFull);
                InputStream is = null;
                HttpResponse respuesta = null;
                String resultado = null;
                try
                {
                    respuesta = clienteHttp.execute(httpPost);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                HttpEntity entity = respuesta.getEntity();
                try
                {
                    is = entity.getContent();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                // Lee el fichero de datos y genera una cadena de texto como resultado
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                String linea = null;

                try
                {
                    while ((linea = br.readLine()) != null)
                    {
                        sb.append(linea + "\n");
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                resultado = sb.toString();
                */
                // Create a new RestTemplate instance
                /*
                RestTemplate restTemplate = new RestTemplate();

// Add the String message converter
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

// Make the HTTP GET request, marshaling the response to a String
                String result = restTemplate.getForObject(urlFull, String.class, "SpringSource");

                */
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
                rma.startActivityForResult(intent, Constants.RESULTADO_CARGAR_IMAGEN);
                //TODO PENSAR COMO GUARDARLA (DE MANERA QUE JUEGUES CON SQLITE)
                break;
        }
    }
}