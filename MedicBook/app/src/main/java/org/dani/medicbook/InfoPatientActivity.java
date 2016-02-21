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
import android.widget.RadioButton;

import org.dani.medicbook.controller.ThreadInfoPatient;
import org.dani.medicbook.model.Constants;

import static org.dani.medicbook.model.Constants.RESULTADO_CARGAR_IMAGEN;

public class InfoPatientActivity extends Fragment implements View.OnClickListener
{
    public int id;
    public View rootView;
    public EditText editText16;
    public EditText editText17;
    public EditText editText18;
    public EditText editText19;
    public EditText editText20;
    public EditText editText21;
    public EditText editText24;
    public RadioButton radioButton;
    public RadioButton radioButton2;
    public Button button5;
    public Button button6;
    public String sex;
    public ImageButton imageButton3;

    public Bitmap image;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.activity_info_patient, container, false);

        this.editText16= (EditText) rootView.findViewById(R.id.editText16);
        this.editText17= (EditText) rootView.findViewById(R.id.editText17);
        this.editText18= (EditText) rootView.findViewById(R.id.editText18);
        this.editText19= (EditText) rootView.findViewById(R.id.editText19);
        this.editText20= (EditText) rootView.findViewById(R.id.editText20);
        this.editText21= (EditText) rootView.findViewById(R.id.editText21);
        this.editText24 = (EditText) rootView.findViewById(R.id.editText24);
        this.radioButton = (RadioButton) rootView.findViewById(R.id.radioButton);
        this.radioButton2 = (RadioButton) rootView.findViewById(R.id.radioButton2);
        button5 = (Button) rootView.findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = (Button) rootView.findViewById(R.id.button6);
        button6.setOnClickListener(this);
        imageButton3 = (ImageButton) rootView.findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(this);

        MainFragmentPatientActivity activity = (MainFragmentPatientActivity) getActivity();
        id = activity.paciente;

        ThreadInfoPatient tip = new ThreadInfoPatient(this, id);
        tip.execute();

        return rootView;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button5:
                if(radioButton.isChecked())
                    sex = "H";
                else
                    sex = "M";
                ThreadInfoPatient tim = new ThreadInfoPatient(this, id, editText16.getText().toString(), editText17.getText().toString(), editText18.getText().toString(), editText19.getText().toString(), editText20.getText().toString(), editText21.getText().toString(), editText24.getText().toString(), sex);
                tim.execute();
                break;
            case R.id.button6:
                ThreadInfoPatient tim2 = new ThreadInfoPatient(this, id);
                tim2.execute();
                break;
            case R.id.imageButton3:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
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

            imageButton3 = (ImageButton) rootView.findViewById(R.id.imageButton);
            imageButton3.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}