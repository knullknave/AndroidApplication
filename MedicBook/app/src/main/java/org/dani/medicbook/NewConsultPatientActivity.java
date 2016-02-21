package org.dani.medicbook;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.dani.medicbook.base.Medic;
import org.dani.medicbook.controller.ThreadAddVisitPatient;

public class NewConsultPatientActivity extends Fragment implements View.OnClickListener
{
    public View rootView;
    public EditText editText14;
    public EditText editText15;
    public Button btnAccept;
    public Button btnCentre;
    public Spinner spinner2;
    public String centroMedico;
    public int id;

    private static final int CODIGO_ACTIVIDAD = 1;
    private static final int PRIMERA_ACTIVIDAD = 1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.activity_new_consult_patient, container, false);

        editText14 = (EditText) rootView.findViewById(R.id.editText14);
        editText15 = (EditText) rootView.findViewById(R.id.editText15);
        btnAccept = (Button) rootView.findViewById(R.id.btnAccept);
        btnAccept.setOnClickListener(this);
        btnCentre = (Button) rootView.findViewById(R.id.btnCentre);
        btnCentre.setOnClickListener(this);
        spinner2 = (Spinner) rootView.findViewById(R.id.spinner2);

        MainFragmentPatientActivity activity = (MainFragmentPatientActivity) getActivity();
        id = activity.paciente;

        ThreadAddVisitPatient tavp = new ThreadAddVisitPatient(this, id);
        tavp.execute();

        centroMedico = "";

        return rootView;
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btnAccept:
                if(spinner2.getCount() > 0 && !editText14.getText().equals("") && !editText15.getText().equals(""))
                {
                    int idPatient = ((Medic) spinner2.getSelectedItem()).getId();
                    ThreadAddVisitPatient tavp = new ThreadAddVisitPatient(this, this.id, editText14.getText().toString(), editText15.getText().toString(), idPatient);
                    tavp.execute();
                }
                else
                {
                    Toast.makeText(getActivity(), R.string.error, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCentre:
                Intent intent = new Intent(getActivity(), PatientMapActivity.class);
                getActivity().startActivityForResult(intent, CODIGO_ACTIVIDAD);
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK)
        {
            Uri dato = data.getData();
            String nombre = data.getDataString();
            Toast.makeText(getActivity(), nombre, Toast.LENGTH_LONG).show();
            editText15.setText(nombre);
        }
    }
}