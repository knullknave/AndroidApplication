package org.dani.medicbook.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper2 extends SQLiteOpenHelper
{
    private static final String DB_NAME = "Conf.sqlite";
    private static final int DB_SCHEME_VERSION = 1;

    public DbHelper2(Context context)
    {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DataBaseManager2.CREATE_TABLE);
        db.insert(DataBaseManager2.TABLE_NAME, null, generarContentValues("http://192.168.2.6:8080"));
    }

    private ContentValues generarContentValues(String ip)
    {
        ContentValues valores = new ContentValues();
        valores.put(DataBaseManager2.CN_IP, ip);

        return  valores;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //Log.w("TaskDBAdapter", "Upgrading from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.TABLE_NAME);

        db.execSQL(DataBaseManager.CREATE_TABLE);
    }
}