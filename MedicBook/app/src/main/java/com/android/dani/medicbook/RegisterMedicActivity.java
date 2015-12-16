package com.android.dani.medicbook;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.android.dani.medicbook.controller.ControllerMedicRegister;

import static com.android.dani.medicbook.model.Constants.RESULTADO_CARGAR_IMAGEN;

public class RegisterMedicActivity extends ActionBarActivity
{
    ControllerMedicRegister cmr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_medic);

        cmr = new ControllerMedicRegister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                Intent intent = new Intent(this, ConfigurationActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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

            cmr.imageButton = (ImageButton) findViewById(R.id.imageButton);
            cmr.imageButton.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}