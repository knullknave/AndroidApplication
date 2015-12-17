package org.dani.medicbook;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ConsultsPatientActivity extends Fragment
{
    View rootView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.activity_consults_patient, container, false);
        return rootView;
    }

    //todo create the listview
}