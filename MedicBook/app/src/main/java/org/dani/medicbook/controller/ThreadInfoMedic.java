package org.dani.medicbook.controller;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.dani.medicbook.InfoMedicActivity;
import org.dani.medicbook.R;
import org.dani.medicbook.base.Medic;
import org.dani.medicbook.database.DataBaseManager;
import org.dani.medicbook.database.DataBaseManager2;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.net.URL;

public class ThreadInfoMedic extends AsyncTask<URL, Integer, Long>
{
    private InfoMedicActivity ima;
    private int id;
    private int sw;

    private Medic[] m;

    private String user;
    private String pass;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String email;
    private String spec;
    private String centre;
    public int idFoto;

    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private EditText editText8;
    private EditText editText9;
    private EditText editText10;
    private EditText editText13;
    private ImageButton imageButton2;

    //WHEN TAB IS CREATED
    public ThreadInfoMedic(InfoMedicActivity ima, int id) {
        this.ima = ima;
        this.id = id;
        sw = 0;

        this.imageButton2 = (ImageButton) ima.rootView.findViewById(R.id.imageButton2);
        this.editText3 = (EditText) ima.rootView.findViewById(R.id.editText3);
        this.editText4 = (EditText) ima.rootView.findViewById(R.id.editText4);
        this.editText5 = (EditText) ima.rootView.findViewById(R.id.editText5);
        this.editText6 = (EditText) ima.rootView.findViewById(R.id.editText6);
        this.editText7 = (EditText) ima.rootView.findViewById(R.id.editText7);
        this.editText8 = (EditText) ima.rootView.findViewById(R.id.editText8);
        this.editText9 = (EditText) ima.rootView.findViewById(R.id.editText9);
        this.editText10 = (EditText) ima.rootView.findViewById(R.id.editText10);
        this.editText13 = (EditText) ima.rootView.findViewById(R.id.editText13);
    }

    //WHEN ACCEPT IS CLICKED
    public ThreadInfoMedic(InfoMedicActivity ima, int id, String u, String p, String n, String s, String ph, String a, String e, String sp, String c) {
        this.ima = ima;
        this.id = id;

        this.user = u;
        this.pass = p;
        this.name = n;
        this.surname = s;
        this.phone = ph;
        this.address = a;
        this.email = e;
        this.spec = sp;
        this.centre = c;

        sw = 1;
    }

    public void search(String url)
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.m = restTemplate.getForObject(url, Medic[].class);
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
            DataBaseManager2 manager2 = new DataBaseManager2(ima.getActivity());
            Cursor cursor2 = manager2.cargarCursor();
            cursor2.moveToLast();
            String SERVER_URL = cursor2.getString(0);

            search(String.valueOf(SERVER_URL + "/medico?id=" + id));

            ima.getActivity().runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    if (m.length > 0)
                    {
                        editText3.setText(m[0].getUsername().toString());
                        editText4.setText(m[0].getPas().toString());
                        editText5.setText(m[0].getName().toString());
                        editText6.setText(m[0].getSurname().toString());
                        editText7.setText(m[0].getTelephone().toString());
                        editText8.setText(m[0].getAdress().toString());
                        editText9.setText(m[0].getEmail().toString());
                        editText10.setText(m[0].getSpec().toString());
                        editText13.setText(m[0].getMed().toString());
                        idFoto = m[0].getIdFoto();

                        DataBaseManager manager = new DataBaseManager(ima.getActivity());
                        Cursor cursor = manager.cargarCursorFotos();

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
                            //Bitmap back = Bitmap.createBitmap(background.getWidth(), background.getHeight(), Bitmap.Config.ARGB_8888);

                            imageButton2.setImageBitmap(background);
                        }
                    }
                }
            });
        }
        else
        {
            DataBaseManager2 manager2 = new DataBaseManager2(ima.getActivity());
            Cursor cursor2 = manager2.cargarCursor();
            cursor2.moveToLast();
            String SERVER_URL = cursor2.getString(0);

            String url = "/update_medic?id=" + id + "&username=" + user.trim() + "&userpassword=" + pass.trim() + "&name=" + name.trim() + "&surname=" +
                    surname.trim() + "&adress=" + address.trim() + "&medicalcentre=" + centre.trim() + "&email=" +
                    email.trim() + "&medicalspeciality=" + spec.trim() + "&telephone=" + phone.trim() + "&idfoto" + 0;

            if(store(SERVER_URL + url) == true)
            {
                ima.getActivity().runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        DataBaseManager manager = new DataBaseManager(ima.getActivity());
                        manager.modificar(idFoto, imageButton2.getDrawingCache(), "Medico");
                        Toast.makeText(ima.getActivity(), ima.getActivity().getResources().getString(R.string.successful), Toast.LENGTH_LONG).show();
                    }
                });
            }
            else
            {
                ima.getActivity().runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(ima.getActivity(), ima.getActivity().getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
        return null;
    }
}
