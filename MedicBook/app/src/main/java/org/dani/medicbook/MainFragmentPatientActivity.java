package org.dani.medicbook;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import org.dani.medicbook.controller.TabListener;

public class MainFragmentPatientActivity extends ActionBarActivity
{
    ActionBar.Tab consult, newC, infoM;
    Fragment consults = new ConsultsPatientActivity();
    Fragment newCs = new NewConsultPatientActivity();
    Fragment infosP = new InfoPatientActivity();
    public int paciente;

    public String name;

    private static final int CODIGO_ACTIVIDAD = 1;
    private static final int PRIMERA_ACTIVIDAD = 1;

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

        name = "";
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CODIGO_ACTIVIDAD)
        {
            if(resultCode == RESULT_OK)
            {
                String nombre = data.getStringExtra("centro");
                name = nombre;
            }
        }
    }
}