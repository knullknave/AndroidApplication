package org.dani.medicbook;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import org.dani.medicbook.controller.ControllerLogin;
import org.dani.medicbook.database.SQLiteDB;

public class LoginActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SQLiteDB medDBv= new SQLiteDB(this, "medicDB", null, 1);
        SQLiteDatabase db = medDBv.getWritableDatabase();
        if(db != null)
        {
            db.execSQL("INSERT INTO Medic (userName, userPassword, name, surname, adress, medicalCentre, email, medicalSpeciality, telephone, birthDate) " +
                    "VALUES ('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', '10/04/1995')");
            db.close();
        }

        ControllerLogin cl = new ControllerLogin(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                Intent intent = new Intent(this, ConfigurationActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_about:
                Intent intent2 = new Intent(this, AboutActivity.class);
                startActivity(intent2);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}