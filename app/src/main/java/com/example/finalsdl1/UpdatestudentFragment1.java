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
import com.example.finalsdl1.studentDbHelper1;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdatestudentFragment1 extends Fragment {
    private EditText Update_id,Update_name,Update_email,Update_college_name,Update_contact_no;
    private Button Update_bn;

    public UpdatestudentFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_updatestudent1, container, false);
        Update_id=view.findViewById(R.id.text_update_id);
        Update_name=view.findViewById(R.id.text_update_name);
        Update_email=view.findViewById(R.id.text_update_email);
        Update_college_name=view.findViewById(R.id.text_update_college_name);
        Update_contact_no=view.findViewById(R.id.text_update_contact_no);


        Update_bn=view.findViewById(R.id.bn_update_save);
        Update_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updatestudent();

            }
        });
        return view;
    }
    private void updatestudent(){
        int id= Integer.parseInt(Update_id.getText().toString());
        String name= Update_name.getText().toString();
        String email= Update_email.getText().toString();
        String college_name=Update_college_name.getText().toString();
        int  contact_no= Integer.parseInt(Update_contact_no.getText().toString());

        studentDbHelper1 studentDbHelper1 =new studentDbHelper1(getActivity());
        SQLiteDatabase database= studentDbHelper1.getWritableDatabase();
        studentDbHelper1.updatestudent(id,name,email,college_name,contact_no,database);
        studentDbHelper1.close();
        Toast.makeText(getActivity(),"Student Updated...",Toast.LENGTH_SHORT).show();
        Update_id.setText("");
        Update_name.setText("");
        Update_email.setText("");
        Update_college_name.setText("");
        Update_contact_no.setText("");

    }
}



