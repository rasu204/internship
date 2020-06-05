package com.example.finalsdl1;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.InternshipContract;
import com.InternshipDbHelper;
import com.example.finalsdl1.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadInternshipFragment extends Fragment {
    private TextView Text_Display;

    public ReadInternshipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_internship, container, false);
        Text_Display= view.findViewById(R.id.text_display);
        readInternship();
        return view;
    }
    private void readInternship()
    {

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
            info =info+"\n\n\n"+"Company Name : " +company_name+"\nActivity :"+activity+"\nActivity ID : "+activity_id+"\nTitle : "+title+"\nStart Date : "+start_date+"\nDuration : "+duration+"\nStipend : "+stipend+"\nDescription : "+description;
        }
        Text_Display.setText(info);
        internshipDbHelper.close();
    }


}
