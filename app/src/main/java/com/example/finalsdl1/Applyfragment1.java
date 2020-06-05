package com.example.finalsdl1;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.InternshipContract;
import com.InternshipDbHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class Applyfragment1 extends Fragment {
    private TextView Text_Display;

    public Applyfragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_applyfragment1, container, false);

        Text_Display = view.findViewById(R.id.text_display);
        Apply();
        return view;
    }

    private void Apply()
    {
        Toast.makeText(getActivity()," Applied Successfully...",Toast.LENGTH_SHORT).show();
        InternshipDbHelper internshipDbHelper= new InternshipDbHelper(getActivity());
        SQLiteDatabase database=internshipDbHelper.getReadableDatabase();
        Cursor cursor=internshipDbHelper.readinternship(database);
        String info="";
        while (cursor.moveToNext())
        {
            String company_name=cursor.getString(cursor.getColumnIndex(InternshipContract.InternshipEntry.COMPANY_NAME));
            String activity=cursor.getString(cursor.getColumnIndex(InternshipContract.InternshipEntry.ACTIVITY));
            String activity_id=Integer.toString(cursor.getInt(cursor.getColumnIndex(InternshipContract.InternshipEntry.ACTIVITY_ID)));
            String title=cursor.getString(cursor.getColumnIndex(InternshipContract.InternshipEntry.TITLE));
            String start_date=cursor.getString(cursor.getColumnIndex(InternshipContract.InternshipEntry.START_DATE));
            String duration=Integer.toString(cursor.getInt(cursor.getColumnIndex(InternshipContract.InternshipEntry.DURATION)));
            String stipend=Integer.toString(cursor.getInt(cursor.getColumnIndex(InternshipContract.InternshipEntry.STIPEND)));
            String description=cursor.getString(cursor.getColumnIndex(InternshipContract.InternshipEntry.DESCRIPTION));
            info =info+"\n"+"Company Name : " +company_name+"\nActivity :"+activity+"\nActivity ID : "+activity_id+"\nTitle : "+title+"\nStart Date : "+start_date+"\nDuration : "+duration+"\nStipend : "+stipend+"\nDescription : "+description;
        }
        Text_Display.setText(info);
        internshipDbHelper.close();
    }

}
