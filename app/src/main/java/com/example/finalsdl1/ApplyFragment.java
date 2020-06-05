package com.example.finalsdl1;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.InternshipDbHelper;
import com.example.finalsdl1.R;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class ApplyFragment extends Fragment {

    private Button bnSave;
    EditText Company_name,Activity,Activity_id,Title,Start_date,Duration,Stipend,Description;

    public ApplyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apply, container, false);
        bnSave=view.findViewById(R.id.bn_save);
        Company_name = view.findViewById(R.id.text_company_name);
        Activity= view.findViewById(R.id.text_activity);
        Activity_id= view.findViewById(R.id.text_activity_id);
        Title = view.findViewById(R.id.text_title);
        Start_date=view.findViewById(R.id.text_start_date);
        Duration=view.findViewById(R.id.text_duration);
        Stipend=view.findViewById(R.id.text_stipend);
        Description=view.findViewById(R.id.text_description);
        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String company_name=Company_name.getText().toString();
                String activity=Activity.getText().toString();
                String activity_id=Activity_id.getText().toString();
                String title=Title.getText().toString();
                String start_date=Start_date.getText().toString();
                String duration=Duration.getText().toString();
                String stipend=Stipend.getText().toString();
                String description=Description.getText().toString();

                InternshipDbHelper internshipDbHelper=new InternshipDbHelper(getActivity());
                SQLiteDatabase database=internshipDbHelper.getWritableDatabase();
                internshipDbHelper.addinternship(company_name,activity,Integer.parseInt(activity_id),title,start_date,Integer.parseInt(duration),Integer.parseInt(stipend),description,database);
                internshipDbHelper.close();
                Company_name.setText("");
                Activity.setText("");
                Activity_id.setText("");
                Title.setText("");
                Start_date.setText("");
                Duration.setText("");
                Stipend.setText("");
                Description.setText("");
                Toast.makeText(getActivity(),"New Internship Added Successfully...",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
