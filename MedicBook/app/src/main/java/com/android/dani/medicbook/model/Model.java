package com.android.dani.medicbook.model;

import android.widget.Toast;

import com.android.dani.medicbook.LoginActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model
{
    LoginActivity la;

    public Model(LoginActivity la)
    {
        this.la = la;
    }

    public void Connect(String host, String user, String password)
    {
        Connection conexion = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":3306" + "/MedicDB", user, password);
        }
        catch (ClassNotFoundException cnfe)
        {
            Toast.makeText(la, "Error", Toast.LENGTH_SHORT);
        }
        catch (SQLException sqle)
        {
            Toast.makeText(la, "Error", Toast.LENGTH_SHORT);
        }
        catch (InstantiationException ie)
        {
            Toast.makeText(la, "Error", Toast.LENGTH_SHORT);
        }
        catch (IllegalAccessException iae)
        {
            Toast.makeText(la, "Error", Toast.LENGTH_SHORT);
        }
        String sql = "SELECT COUNT(*) FROM medic";

        try
        {
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            Toast.makeText(la, resultado.getInt(1), Toast.LENGTH_LONG);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
