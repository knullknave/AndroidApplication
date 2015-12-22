package org.dani.medicbook;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewConsultMedicActivity extends Fragment implements View.OnClickListener
{
    private View vista;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.activity_newconsult_medic, container, false);
        vista = rootView;

        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner3);
        String[] datos = new String[]{getResources().getString(R.string.whoareyou), getResources().getString(R.string.patient), getResources().getString(R.string.medic)};
        //TODO MAKE A CONSULT AND GET THE PATIENTS OF THE RESULT
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, datos);
        spinner.setAdapter(adaptador);
        return rootView;
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btnAccept:
                //TODO REGISTER A NEW VISIT
                break;
            case R.id.btnCentre:
                //TODO SHOW
                break;
            default:
                break;
        }
    }
}