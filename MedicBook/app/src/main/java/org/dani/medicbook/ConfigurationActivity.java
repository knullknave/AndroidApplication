package org.dani.medicbook;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.dani.medicbook.database.DataBaseManager2;

public class ConfigurationActivity extends ActionBarActivity implements View.OnClickListener
{
    public EditText ipText;
    public Button accept;
    public String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        this.ipText = (EditText) findViewById(R.id.ipText);
        this.accept = (Button) findViewById(R.id.accept);
        accept.setOnClickListener(this);

        DataBaseManager2 manager = new DataBaseManager2(this);
        Cursor cursor = manager.cargarCursor();
        cursor.moveToLast();
        ip = cursor.getString(0);
        ipText.setText(ip);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.accept:
                if(!ipText.getText().equals(""))
                {
                    DataBaseManager2 manager = new DataBaseManager2(this);
                    manager.modificar(ipText.getText().toString(), ip);
                    Toast.makeText(this, "Ok", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
