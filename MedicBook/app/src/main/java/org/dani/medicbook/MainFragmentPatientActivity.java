package org.dani.medicbook;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import org.dani.medicbook.controller.TabListener;

public class MainFragmentPatientActivity extends ActionBarActivity
{
    ActionBar.Tab consult, newC, infoM;
    Fragment consults = new ConsultsPatientActivity();
    Fragment newCs = new NewConsultPatientActivity();
    Fragment infosP = new InfoPatientActivity();
    public int paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment_medic);

        getFragmentManager().findFragmentById(R.id.spinner);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setIcon(R.drawable.ic_setting_bar_1);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        consult = actionBar.newTab().setText(R.string.consults);
        newC = actionBar.newTab().setText(R.string.newconsult);
        infoM = actionBar.newTab().setText(R.string.infopatient);

        consult.setTabListener(new TabListener(consults));
        newC.setTabListener(new TabListener(newCs));
        infoM.setTabListener(new TabListener(infosP));

        actionBar.addTab(consult);
        actionBar.addTab(newC);
        actionBar.addTab(infoM);

        Bundle extras = getIntent().getExtras();
        paciente = extras.getInt("Paciente");
    }
}