package org.dani.medicbook.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

public class DataBaseManager2
{
    public static final String TABLE_NAME = "Conf";

    public static final String CN_IP = "_ip";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + CN_IP + " text not null);";

    private DbHelper2 helper2;
    private SQLiteDatabase db;

    public DataBaseManager2(Context context)
    {
        helper2 = new DbHelper2(context);
        db = helper2.getWritableDatabase();
    }

    private ContentValues generarContentValues(String ip)
    {
        ContentValues valores = new ContentValues();
        valores.put(CN_IP, ip);

        return  valores;
    }

    public Long insertar(String ip)
    {
        Long id = db.insert(TABLE_NAME, null, generarContentValues(ip));
        return id;
    }

    public void eliminar(String ip)
    {
        db.delete(TABLE_NAME, CN_IP + "=?", new String[]{ip});
    }

    public void modificar(String ip, String ip2)
    {
        db.update(TABLE_NAME, generarContentValues(ip), CN_IP + "=?", new String[]{ip2});
    }

    public Cursor cargarCursor()
    {
        Cursor cursor = db.query(TABLE_NAME, new String[]{CN_IP}, null, null, null, null, null);
        return cursor;
    }

    public Cursor buscar(String ip)
    {
        Cursor cursor = db.query(TABLE_NAME, new String[]{CN_IP}, CN_IP + "=?", new String[]{ip}, null, null, null);
        return cursor;
    }

    public void close()
    {
        db.close();
    }
}
