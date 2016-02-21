package org.dani.medicbook.controller;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import org.dani.medicbook.InfoPatientActivity;
import org.dani.medicbook.R;
import org.dani.medicbook.base.Patient;
import org.dani.medicbook.database.DataBaseManager;
import org.dani.medicbook.database.DataBaseManager2;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ThreadInfoPatient extends AsyncTask<URL, Integer, Long>
{
    private InfoPatientActivity ipa;
    private int id;
    private int sw;

    private int idFoto;

    private Patient[] p;

    private String user;
    private String pass;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String birthDate;
    private String sex;
    private static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    private EditText editText16;
    private EditText editText17;
    private EditText editText18;
    private EditText editText19;
    private EditText editText20;
    private EditText editText21;
    private EditText editText24;
    public RadioButton radioButton;
    public RadioButton radioButton2;
    private ImageButton imageButton3;

    public ThreadInfoPatient(InfoPatientActivity ipa, int id) {
        this.ipa = ipa;
        this.id = id;
        sw = 0;

        this.editText16= (EditText) ipa.rootView.findViewById(R.id.editText16);
        this.editText17= (EditText) ipa.rootView.findViewById(R.id.editText17);
        this.editText18= (EditText) ipa.rootView.findViewById(R.id.editText18);
        this.editText19= (EditText) ipa.rootView.findViewById(R.id.editText19);
        this.editText20= (EditText) ipa.rootView.findViewById(R.id.editText20);
        this.editText21= (EditText) ipa.rootView.findViewById(R.id.editText21);
        this.editText24 = (EditText) ipa.rootView.findViewById(R.id.editText24);
        this.radioButton = (RadioButton) ipa.rootView.findViewById(R.id.radioButton);
        this.radioButton2 = (RadioButton) ipa.rootView.findViewById(R.id.radioButton2);
        this.imageButton3 = (ImageButton) ipa.rootView.findViewById(R.id.imageButton3);
    }

    public ThreadInfoPatient(InfoPatientActivity ipa, int id, String u, String p, String n, String s, String ph, String a, String birthDate, String sex)
    {
        this.ipa = ipa;
        this.id = id;

        this.user = u;
        this.pass = p;
        this.name = n;
        this.surname = s;
        this.phone = ph;
        this.address = a;
        this.birthDate = birthDate;
        this.sex = sex;

        sw = 1;
    }

    public void search(String url)
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.p = restTemplate.getForObject(url, Patient[].class);
    }

    public boolean store(String url)
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
        if (sw == 0)
        {
            DataBaseManager2 manager2 = new DataBaseManager2(ipa.getActivity());
            Cursor cursor2 = manager2.cargarCursor();
            cursor2.moveToLast();
            String SERVER_URL = cursor2.getString(0);

            search(String.valueOf(SERVER_URL + "/paciente?id=" + id));

            ipa.getActivity().runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    if (p.length > 0)
                    {
                        editText16.setText(p[0].getUsername().toString());
                        editText17.setText(p[0].getPas().toString());
                        editText18.setText(p[0].getName().toString());
                        editText19.setText(p[0].getSurname().toString());
                        editText20.setText(p[0].getTelephone().toString());
                        editText21.setText(p[0].getAdress().toString());

                        //TODO PROBLEMA AL PARSEAR LA FECHA, FORMATO NO dd-mm-yyyy
                        editText24.setText(p[0].getBirthdate().toString());

                        if(String.valueOf(p[0].getSex()).equals("H"))
                            radioButton.setChecked(true);
                        else
                            radioButton2.setChecked(true);

                        idFoto = p[0].getIdFoto();

                        DataBaseManager manager = new DataBaseManager(ipa.getActivity());
                        Cursor cursor = manager.buscarFoto(String.valueOf(idFoto));
                        if(cursor.getColumnCount() >= idFoto)
                        {
                            cursor.moveToFirst();
                            do
                            {
                                if(cursor.getInt(0) == idFoto)
                                {
                                    break;
                                }
                            }
                            while(cursor.moveToNext());

                            byte[] bArray = cursor.getBlob(1);
                            Bitmap background = BitmapFactory.decodeByteArray(bArray, 0, bArray.length);

                            imageButton3.setImageBitmap(background);
                        }

                    }
                }
            });
        }
        else
        {
            DataBaseManager2 manager2 = new DataBaseManager2(ipa.getActivity());
            Cursor cursor2 = manager2.cargarCursor();
            cursor2.moveToLast();
            String SERVER_URL = cursor2.getString(0);

            String url = "/update_patient?id=" + id + "&username=" + user.trim() + "&userpassword=" + pass.trim() + "&name=" + name.trim() + "&surname=" +
                    surname.trim() + "&sex=" + sex + "&adress=" + address.trim() + "&birthdate="+ birthDate.trim() + "&telephone=" + phone.trim();

            if(store(SERVER_URL + url) == true)
            {
                ipa.getActivity().runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        DataBaseManager manager = new DataBaseManager(ipa.getActivity());
                        manager.modificar(idFoto, imageButton3.getDrawingCache(), "Paciente");
                        Toast.makeText(ipa.getActivity(), ipa.getActivity().getResources().getString(R.string.successful), Toast.LENGTH_LONG).show();
                    }
                });
            }
            else
            {
                ipa.getActivity().runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(ipa.getActivity(), ipa.getActivity().getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
                    }
                });
            }
        }

        return null;
    }
}
