package org.dani.medicbook.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

public class DataBaseManager
{
    public static final String TABLE_NAME = "Fotos";

    public static final String CN_ID = "_id";
    public static final String CN_F = "_foto";
    public static final String CN_T = "_tipo";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + CN_ID + " integer primary key autoincrement,"
            + CN_F + " blob,"
            + CN_T + " text not null);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context)
    {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    private ContentValues generarContentValues(Bitmap foto, String tipo)
    {
        Bitmap photo = foto;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        photo.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] bArray = bos.toByteArray();

        ContentValues valores = new ContentValues();
        valores.put(CN_F, bArray);
        valores.put(CN_T, tipo);

        return  valores;
    }

    public Long insertar(Bitmap foto, String tipo)
    {
        Long id = db.insert(TABLE_NAME, null, generarContentValues(foto, tipo));
        return id;

    }

    public void eliminar(int id)
    {
        db.delete(TABLE_NAME, CN_ID + "=?", new String[]{String.valueOf(id)});
    }

    public void modificar(int id, Bitmap foto, String tipo)
    {
        db.update(TABLE_NAME, generarContentValues(foto, tipo), CN_ID + "=?", new String[]{String.valueOf(id)});
    }

    public Cursor cargarCursorFotos()
    {
        Cursor cursor = db.query(TABLE_NAME, new String[]{CN_ID, CN_F, CN_T}, null, null, null, null, null);
        return cursor;
    }

    public Cursor buscarFoto(String id)
    {
        Cursor cursor = db.query(TABLE_NAME, new String[]{CN_ID, CN_F, CN_T}, CN_ID + "=?", new String[]{id}, null, null, null);
        return cursor;
    }

    public void close()
    {
        db.close();
    }
}