package org.dani.medicbook;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.dani.medicbook.controller.ThreadInfoMedic;
import org.dani.medicbook.model.Constants;

import static org.dani.medicbook.model.Constants.RESULTADO_CARGAR_IMAGEN;

public class InfoMedicActivity extends Fragment implements View.OnClickListener
{
    public int id;
    public View rootView;

    public EditText editText3;
    public EditText editText4;
    public EditText editText5;
    public EditText editText6;
    public EditText editText7;
    public EditText editText8;
    public EditText editText9;
    public EditText editText10;
    public EditText editText13;
    public Bitmap image;
    public ImageButton imageButton2;

    public Button button3;
    public Button button4;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.activity_info_medic, container, false);

        this.editText3 = (EditText) rootView.findViewById(R.id.editText3);
        this.editText4 = (EditText) rootView.findViewById(R.id.editText4);
        this.editText5 = (EditText) rootView.findViewById(R.id.editText5);
        this.editText6 = (EditText) rootView.findViewById(R.id.editText6);
        this.editText7 = (EditText) rootView.findViewById(R.id.editText7);
        this.editText8 = (EditText) rootView.findViewById(R.id.editText8);
        this.editText9 = (EditText) rootView.findViewById(R.id.editText9);
        this.editText10 = (EditText) rootView.findViewById(R.id.editText10);
        this.editText13 = (EditText) rootView.findViewById(R.id.editText13);
        button3 = (Button) rootView.findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) rootView.findViewById(R.id.button4);
        button4.setOnClickListener(this);
        imageButton2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(this);

        MainFragmentMedicActivity activity = (MainFragmentMedicActivity) getActivity();
        id = activity.medico;

        ThreadInfoMedic tim = new ThreadInfoMedic(this, id);
        tim.execute();

        return rootView;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button3:
                ThreadInfoMedic tim = new ThreadInfoMedic(this, id, editText3.getText().toString(), editText4.getText().toString(), editText5.getText().toString(), editText6.getText().toString(), editText7.getText().toString(), editText8.getText().toString(), editText9.getText().toString(), editText10.getText().toString(), editText13.getText().toString());
                tim.execute();
                break;
            case R.id.button4:
                ThreadInfoMedic tim2 = new ThreadInfoMedic(this, id);
                tim2.execute();
                break;
            case R.id.imageButton2:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                //startActivityForResult Not Working on Fragments
                startActivityForResult(intent, Constants.RESULTADO_CARGAR_IMAGEN);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if((requestCode == RESULTADO_CARGAR_IMAGEN) && (resultCode == getActivity().RESULT_OK) && (data != null))
        {
            Uri imagenSeleccionada = data.getData();
            String ruta[] = {MediaStore.Images.Media.DATA};
            Cursor cursor = getActivity().getContentResolver().query(imagenSeleccionada, ruta, null, null, null);
            cursor.moveToFirst();

            int indice = cursor.getColumnIndex(ruta[0]);
            String picturePath = cursor.getString(indice);
            cursor.close();

            image = BitmapFactory.decodeFile(picturePath);

            imageButton2 = (ImageButton) rootView.findViewById(R.id.imageButton);
            imageButton2.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}