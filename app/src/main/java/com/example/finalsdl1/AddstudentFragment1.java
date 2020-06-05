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

import com.example.finalsdl1.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddstudentFragment1 extends Fragment {

    private Button bnSave;
    EditText Id, Name, Email, College_Name, Contact_No;


    public AddstudentFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_addstudent1, container, false);

        bnSave = view.findViewById(R.id.bn_save);
        Id = view.findViewById(R.id.text_id);
        Name = view.findViewById(R.id.text_name);
        Email = view.findViewById(R.id.text_email);
        College_Name = view.findViewById(R.id.text_college_name);
        Contact_No = view.findViewById(R.id.text_contact_no);


        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = Id.getText().toString();
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String college_Name = College_Name.getText().toString();
                String contact_No = Contact_No.getText().toString();

                com.example.finalsdl1.studentDbHelper1 studentDbHelper1 = new studentDbHelper1(getActivity());
                SQLiteDatabase database = studentDbHelper1.getWritableDatabase();
                studentDbHelper1.addstudent(Integer.parseInt(id), name, email, college_Name, Integer.parseInt(contact_No), database);
                studentDbHelper1.close();
                Id.setText("");
                Name.setText("");
                Email.setText("");
                College_Name.setText("");
                Contact_No.setText("");
                Toast.makeText(getActivity(), "student information saved successfully...", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}




