package org.dani.medicbook;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.dani.medicbook.base.Patient;
import org.dani.medicbook.controller.ThreadAddVisitMedic;

public class NewConsultMedicActivity extends Fragment implements View.OnClickListener
{
    public View rootView;
    public EditText editText;
    public EditText editText2;
    public Button btnAccept;
    public Button btnCentre;
    public Spinner spinner;
    public String centroMedico;
    public int id;

    private static final int CODIGO_ACTIVIDAD = 1;
    private static final int PRIMERA_ACTIVIDAD = 1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.activity_newconsult_medic, container, false);

        editText = (EditText) rootView.findViewById(R.id.editText);
        editText2 = (EditText) rootView.findViewById(R.id.editText2);
        btnAccept = (Button) rootView.findViewById(R.id.btnAccept);
        btnAccept.setOnClickListener(this);
        btnCentre = (Button) rootView.findViewById(R.id.btnCentre);
        btnCentre.setOnClickListener(this);
        spinner = (Spinner) rootView.findViewById(R.id.spinner3);

        MainFragmentMedicActivity activity = (MainFragmentMedicActivity) getActivity();
        id = activity.medico;

        ThreadAddVisitMedic tavm = new ThreadAddVisitMedic(this, id);
        tavm.execute();

        centroMedico = "";

        return rootView;
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btnAccept:
                if(spinner.getCount() > 0 && !editText2.getText().equals("") && !editText.getText().equals(""))
                {
                    int idPatient = ((Patient) spinner.getSelectedItem()).getId();
                    ThreadAddVisitMedic tavm = new ThreadAddVisitMedic(this, this.id, editText.getText().toString(), editText2.getText().toString(), idPatient);
                    tavm.execute();
                }
                else
                {
                    Toast.makeText(getActivity(), R.string.error, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCentre:
                Intent intent = new Intent(getActivity(), MedicMapActivity.class);
                getActivity().startActivityForResult(intent, CODIGO_ACTIVIDAD);
            default:
                break;
        }
    }

    //TODO NO ENTRA
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CODIGO_ACTIVIDAD)
        {
            if(resultCode == getActivity().RESULT_OK)
            {
                String nombre = data.getStringExtra("centro");
                Toast.makeText(getActivity(), nombre, Toast.LENGTH_LONG).show();
                editText2.setText(nombre);
            }
        }
    }
}