package com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.ParcelUuid;
import android.util.Log;

import com.example.finalsdl1.studentDbHelper1;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class InternshipDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "database_1";
    public static final int DATABASE_VERSION =2;
    public static final String CREATE_TABLE ="create table "+InternshipContract.InternshipEntry.TABLE_NAME+ "("+InternshipContract.InternshipEntry.COMPANY_NAME+ " text,"+ InternshipContract.InternshipEntry.ACTIVITY+ " text,"+InternshipContract.InternshipEntry.ACTIVITY_ID+ " number,"+ InternshipContract.InternshipEntry.TITLE+ " text,"+InternshipContract.InternshipEntry.START_DATE+ " text,"+InternshipContract.InternshipEntry.DURATION+ " number,"+InternshipContract.InternshipEntry.STIPEND+ " number,"+InternshipContract.InternshipEntry.DESCRIPTION+ " text);";
    public static final String DROP_TABLE ="Drop table if exists "+InternshipContract.InternshipEntry.TABLE_NAME;
    public InternshipDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("Database Operations","Database Created..");
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Database Operations","Table Created..");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);

    }

    public void addinternship(String company_name, String activity, int activity_id, String title, String  start_date, int duration, int stipend,String description, SQLiteDatabase database)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InternshipContract.InternshipEntry.COMPANY_NAME,company_name);
        contentValues.put(InternshipContract.InternshipEntry.ACTIVITY,activity);
        contentValues.put(InternshipContract.InternshipEntry.ACTIVITY_ID,activity_id);
        contentValues.put(InternshipContract.InternshipEntry.TITLE,title);
        contentValues.put(InternshipContract.InternshipEntry.START_DATE,start_date);
        contentValues.put(InternshipContract.InternshipEntry.DURATION,duration);
        contentValues.put(InternshipContract.InternshipEntry.STIPEND,stipend);
        contentValues.put(InternshipContract.InternshipEntry.DESCRIPTION,description);

        database.insert(InternshipContract.InternshipEntry.TABLE_NAME,null,contentValues);
        Log.d("Database Operations","One Row Is Inserted..");
    }

    public Cursor readinternship(SQLiteDatabase database)
    {
        String[]projections={InternshipContract.InternshipEntry.COMPANY_NAME,InternshipContract.InternshipEntry.ACTIVITY, InternshipContract.InternshipEntry.ACTIVITY_ID,InternshipContract.InternshipEntry.TITLE,InternshipContract.InternshipEntry.START_DATE,InternshipContract.InternshipEntry.DURATION,InternshipContract.InternshipEntry.STIPEND,InternshipContract.InternshipEntry.DESCRIPTION};

        Cursor cursor= database.query(InternshipContract.InternshipEntry.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;

    }

    public void updateInternship (String company_name,String activity,int activity_id,String title,String start_date,int duration,int stipend,String description,SQLiteDatabase database)
    {

        ContentValues contentValues=new ContentValues();
        contentValues.put(InternshipContract.InternshipEntry.COMPANY_NAME,company_name);
        contentValues.put(InternshipContract.InternshipEntry.ACTIVITY,activity);
        //contentValues.put(InternshipContract.InternshipEntry.ACTIVITY_ID,activity_id);
        contentValues.put(InternshipContract.InternshipEntry.TITLE,title);
        contentValues.put(InternshipContract.InternshipEntry.START_DATE,start_date);
        contentValues.put(InternshipContract.InternshipEntry.DURATION,duration);
        contentValues.put(InternshipContract.InternshipEntry.STIPEND,stipend);
        contentValues.put(InternshipContract.InternshipEntry.DESCRIPTION,description);

        String selection = InternshipContract.InternshipEntry.ACTIVITY_ID+ " = "+activity_id;
        database.update(InternshipContract.InternshipEntry.TABLE_NAME,contentValues,selection,null);

    }

    public void deleteInternship(int activity_id,SQLiteDatabase database)
    {

        String selection=InternshipContract.InternshipEntry.ACTIVITY_ID+" = "+activity_id;
        database.delete(InternshipContract.InternshipEntry.TABLE_NAME,selection,null);


    }

    public Cursor StudentApply(SQLiteDatabase database)
    {
        Cursor cursor=database.rawQuery("SELECT * FROM Internship WHERE activity_id=?",new String[]{"activity_id"});
        String[]projections={InternshipContract.InternshipEntry.COMPANY_NAME,InternshipContract.InternshipEntry.ACTIVITY, InternshipContract.InternshipEntry.ACTIVITY_ID,InternshipContract.InternshipEntry.TITLE,InternshipContract.InternshipEntry.START_DATE,InternshipContract.InternshipEntry.DURATION,InternshipContract.InternshipEntry.STIPEND,InternshipContract.InternshipEntry.DESCRIPTION};
        // String selection = InternshipContract.InternshipEntry.ACTIVITY_ID+ " = "+equals(activity_id);
        cursor= database.query(InternshipContract.InternshipEntry.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;


    }

    }

