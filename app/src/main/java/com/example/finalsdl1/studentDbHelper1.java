package com.example.finalsdl1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.InternshipContract;

public class studentDbHelper1 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student_db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table " + com.example.sqliteexp.studentcontract1.studententry.TABLE_NAME + "(" + com.example.sqliteexp.studentcontract1.studententry.STUDENT_ID + " number," + com.example.sqliteexp.studentcontract1.studententry.NAME + " text," + com.example.sqliteexp.studentcontract1.studententry.EMAIL + " text," + com.example.sqliteexp.studentcontract1.studententry.COLLEGE_NAME + " text," + com.example.sqliteexp.studentcontract1.studententry.CONTACT_NO + " number);";
    public static final String DROP_TABLE = "drop table if exists " + com.example.sqliteexp.studentcontract1.studententry.TABLE_NAME;


    public studentDbHelper1(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        //Log.d("Database Operations","Database created...");

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Database Operations", "Table created...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);

    }

    public void addstudent(int student_id, String name, String email, String college_name, int contact_no, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(com.example.sqliteexp.studentcontract1.studententry.STUDENT_ID, student_id);
        contentValues.put(com.example.sqliteexp.studentcontract1.studententry.NAME, name);
        contentValues.put(com.example.sqliteexp.studentcontract1.studententry.EMAIL, email);
        contentValues.put(com.example.sqliteexp.studentcontract1.studententry.COLLEGE_NAME, college_name);
        contentValues.put(com.example.sqliteexp.studentcontract1.studententry.CONTACT_NO, contact_no);


        database.insert(com.example.sqliteexp.studentcontract1.studententry.TABLE_NAME, null, contentValues);
        Log.d("Database Operations", "One Raw inserted...");


    }

    public void updatestudent(final int id, final String name, String email, final String college_name, final int contact_no, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(com.example.sqliteexp.studentcontract1.studententry.NAME, name);
        contentValues.put(com.example.sqliteexp.studentcontract1.studententry.EMAIL, email);
        contentValues.put(com.example.sqliteexp.studentcontract1.studententry.COLLEGE_NAME, college_name);
        contentValues.put(com.example.sqliteexp.studentcontract1.studententry.CONTACT_NO, contact_no);


        String selection = com.example.sqliteexp.studentcontract1.studententry.STUDENT_ID + " = " + id;
        database.update(com.example.sqliteexp.studentcontract1.studententry.TABLE_NAME, contentValues, selection, null);

    }

    public Cursor viewStudent(SQLiteDatabase database) {
        String[] projections = {com.example.sqliteexp.studentcontract1.studententry.STUDENT_ID, com.example.sqliteexp.studentcontract1.studententry.NAME, com.example.sqliteexp.studentcontract1.studententry.EMAIL, com.example.sqliteexp.studentcontract1.studententry.COLLEGE_NAME, com.example.sqliteexp.studentcontract1.studententry.CONTACT_NO};

        Cursor cursor = database.query(com.example.sqliteexp.studentcontract1.studententry.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;

    }

    public void Deletestudent(int id,SQLiteDatabase database)
    {

        String selection = com.example.sqliteexp.studentcontract1.studententry.STUDENT_ID +" = "+ id;
        database.delete( com.example.sqliteexp.studentcontract1.studententry.TABLE_NAME,selection,null);


    }

    public Cursor studentapply(SQLiteDatabase database, studentDbHelper1 activity_id)
    {
        Cursor cursor=database.rawQuery("SELECT * FROM Internship WHERE activity_id=?",new String[]{"activity_id"});
        String[]projections={InternshipContract.InternshipEntry.COMPANY_NAME,InternshipContract.InternshipEntry.ACTIVITY, InternshipContract.InternshipEntry.ACTIVITY_ID,InternshipContract.InternshipEntry.TITLE,InternshipContract.InternshipEntry.START_DATE,InternshipContract.InternshipEntry.DURATION,InternshipContract.InternshipEntry.STIPEND,InternshipContract.InternshipEntry.DESCRIPTION};
       // String selection = InternshipContract.InternshipEntry.ACTIVITY_ID+ " = "+equals(activity_id);
        cursor= database.query(InternshipContract.InternshipEntry.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;


    }


}














