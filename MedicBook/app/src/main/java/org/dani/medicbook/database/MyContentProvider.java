package org.dani.medicbook.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider
{
    public static final Uri CONTENT_URI = Uri.parse("content://com.android.dani.medicbook/elements");

    private static final int ALLROWS = 1;
    private static final int SINGLE_ROW = 2;

    private static final UriMatcher uriMatcher;

    static
    {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.android.dani.medicbook", "elements", ALLROWS);
        uriMatcher.addURI("com.android.dani.medicbook", "elements/#", SINGLE_ROW);
    }

    public static final String KEY_ID = "_id";
    public static final String KEY_COLUMN_1_NAME = "KEY_COLUMN_1_NAME";

    private SQLiteDB medDB;

    @Override
    public boolean onCreate()
    {
        medDB = new SQLiteDB(getContext(), "medicDB", null, 1);

        return true;
    }

    //ACTIONS FOR DATABASE
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        return null;
    }

    @Override
    public String getType(Uri uri)
    {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        SQLiteDatabase db = medDB.getWritableDatabase();
        db.execSQL("INSERT INTO Medic (userName, userPassword, name, surname, adress, medicalCentre, email, medicalSpeciality, telephone, birthDate) " +
                   "VALUES ('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', '2005-05-10')");



        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs)
    {
        return 0;
    }
}
