package com.android.dani.medicbook;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageButton;

import com.android.dani.medicbook.controller.ControllerPatientRegister;

import static com.android.dani.medicbook.model.Constants.RESULTADO_CARGAR_IMAGEN;

public class RegisterPatientActivity extends ActionBarActivity
{
    ControllerPatientRegister cpr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);

        cpr = new ControllerPatientRegister(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if((requestCode == RESULTADO_CARGAR_IMAGEN) && (resultCode == RESULT_OK) && (data != null))
        {
            Uri imagenSeleccionada = data.getData();
            String ruta[] = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(imagenSeleccionada, ruta, null, null, null);
            cursor.moveToFirst();

            int indice = cursor.getColumnIndex(ruta[0]);
            String picturePath = cursor.getString(indice);
            cursor.close();

            cpr.imageButton = (ImageButton) findViewById(R.id.imageButton);
            cpr.imageButton.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}