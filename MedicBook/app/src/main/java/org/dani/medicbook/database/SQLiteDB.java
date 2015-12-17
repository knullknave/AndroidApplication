package org.dani.medicbook.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteDB extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "myDatabase.db";
    private static final String DATABASE_TABLE_1 = "Medic";
    private static final String DATABASE_TABLE_2 = "Patient";
    private static final String DATABASE_TABLE_3 = "Visit";

    //MEDIC
    private static final String KEY_ID = "id";
    private static final String M_USER_NAME = "userName";
    private static final String M_USER_PASS = "userPassword";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String ADDRESS = "adress";
    private static final String MEDICAL_CENTRE = "medicalCentre";
    private static final String M_EMAIL = "email";
    private static final String MEDICAL_SPECIALITY = "medicalSpeciality";
    private static final String TELEPHONE = "telephone";
    private static final String BIRTH_DATE = "birthDate";

    //PATIENT
    //SAME ID
    private static final String P_USER_NAME = "patientUser";
    private static final String P_USER_PASS = "patientPassword";
    //SAME NAME
    //SAME SURNAME
    private static final String P_SEX = "sex";
    //SAME ADDRESS
    //SAME BIRTHDATE
    //SAME TELEPHONE
    private static final String P_BLOOD_TYPE = "bloodType";

    //VISIT
    private static final String RECEPTION = "reception";
    private static final String VISIT_DATE = "visitDate";
    //SAME MEDICAL_CENTRE
    private static final String MED_ID = "idMedic";
    private static final String PAT_ID = "idPatient";


    private static final int DATABASE_VERSION = 1;
    //MEDIC TABLE
    private static final String DATABASE_CREATE = "CREATE TABLE " + DATABASE_TABLE_1 + " (" + KEY_ID + " integer primary key autoincrement, "
                                                                                            + M_USER_NAME + " text not null, "
                                                                                            + M_USER_PASS + " text not null, "
                                                                                            + NAME + " text not null, "
                                                                                            + SURNAME + " text not null, "
                                                                                            + ADDRESS + " text not null, "
                                                                                            + MEDICAL_CENTRE + " text not null, "
                                                                                            + M_EMAIL + " text not null, "
                                                                                            + MEDICAL_SPECIALITY + " text not null, "
                                                                                            + TELEPHONE + " text not null, "
                                                                                            + BIRTH_DATE + " date);";
    //PATIENT TABLE
    private static final String DATABASE_CREATE2 = "CREATE TABLE " + DATABASE_TABLE_2 + " (" + KEY_ID + " integer primary key autoincrement, "
                                                                                             + P_USER_NAME + " text not null, "
                                                                                             + P_USER_PASS + " text not null, "
                                                                                             + NAME + " text not null, "
                                                                                             + SURNAME + " text not null, "
                                                                                             + ADDRESS + " text not null, "
                                                                                             + P_SEX + " text not null, "
                                                                                             + BIRTH_DATE + " date not null, "
                                                                                             + TELEPHONE + " text not null, "
                                                                                             + P_BLOOD_TYPE + " text mot null);";
    //VISIT TABLE
    private static final String DATABASE_CREATE3 = "CREATE TABLE " + DATABASE_TABLE_3 + " (" + KEY_ID + " integer primary key autoincrement, "
                                                                                             + RECEPTION + " date not null, "
                                                                                             + VISIT_DATE + " text not null, "
                                                                                             + MEDICAL_CENTRE + " text not null, "
                                                                                             + MED_ID + " integer, "
                                                                                             + PAT_ID + " integer);";

    public SQLiteDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    public SQLiteDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler)
    {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w("TaskDBAdapter", "Upgrading from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_1);
        //db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_2);
        //db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_3);

        onCreate(db);
    }

    //TODO CREATE ONLY MEDIC, PATIENT AND VISIT TABLES.
}