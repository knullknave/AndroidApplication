package org.dani.medicbook;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import org.dani.medicbook.controller.TabListener;

public class MainFragmentMedicActivity extends ActionBarActivity
{
    ActionBar.Tab consult, newC, infoM;
    Fragment consults = new ConsultsMedicActivity();
    Fragment newCs = new NewConsultMedicActivity();
    Fragment infosM = new InfoMedicActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment_medic);

        getFragmentManager().findFragmentById(R.id.spinner);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //TODO SET ICON FOR ACTION BAR AND ACTIONS FOR IT

        consult = actionBar.newTab().setText(R.string.consults);
        newC = actionBar.newTab().setText(R.string.newconsult);
        infoM = actionBar.newTab().setText(R.string.infomedic);

        consult.setTabListener(new TabListener(consults));
        newC.setTabListener(new TabListener(newCs));
        infoM.setTabListener(new TabListener(infosM));

        actionBar.addTab(consult);
        actionBar.addTab(newC);
        actionBar.addTab(infoM);
    }
}