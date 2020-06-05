package com.example.finalsdl1;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalsdl1.R;
import com.example.finalsdl1.studentDbHelper1;

//import com.studentcontract1;
//import com.studentDbHelper1;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewstudentFragment1 extends Fragment {
    private TextView Text_Display;

    public ViewstudentFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_viewstudent1, container, false);
        Text_Display= view.findViewById(R.id.text_display);
        viewstudent();
        return view;
    }
    private void viewstudent() {

        studentDbHelper1 studentDbHelper1 = new studentDbHelper1(getActivity());
        SQLiteDatabase database = studentDbHelper1.getReadableDatabase();
        Cursor cursor = studentDbHelper1.viewStudent(database);
        String info = "";
        while (cursor.moveToNext()) {
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(com.example.sqliteexp.studentcontract1.studententry.STUDENT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(com.example.sqliteexp.studentcontract1.studententry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(com.example.sqliteexp.studentcontract1.studententry.EMAIL));
            String college_name = cursor.getString(cursor.getColumnIndex(com.example.sqliteexp.studentcontract1.studententry.COLLEGE_NAME));
            String contact_no = Integer.toString(cursor.getInt(cursor.getColumnIndex(com.example.sqliteexp.studentcontract1.studententry.CONTACT_NO)));
            info = info + "\n\n\n" + "StudentId: " + id + "\nName :" + name + "\nEmail : " + email + "\nCollege Name : " + college_name + "\nContact No : " + contact_no;

        }
        Text_Display.setText(info);
        studentDbHelper1.close();
    }
    }



