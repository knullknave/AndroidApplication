package com.android.dani.medicbook;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.dani.medicbook.controller.ControllerMainFragmentMedic;

public class NewConsultMedicActivity extends Fragment
{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.activity_newconsult_medic, container, false);

        return rootView;
    }
}