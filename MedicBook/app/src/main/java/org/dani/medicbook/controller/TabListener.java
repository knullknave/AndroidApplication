package org.dani.medicbook.controller;

import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar;
import org.dani.medicbook.R;

public class TabListener implements ActionBar.TabListener
{

    private Fragment fragment;

    public TabListener(Fragment fragment)
    {
        this.fragment = fragment;
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft)
    {
        ft.replace(R.id.mainfragment, fragment);
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft)
    {
        ft.remove(fragment);
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft)
    {

    }
}