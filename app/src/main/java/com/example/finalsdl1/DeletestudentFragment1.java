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
public class DeletestudentFragment1 extends Fragment {



        private EditText Id;
        private Button Button_delete;
        public DeletestudentFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_deletestudent3, container, false);
        Id = view.findViewById(R.id.text_delete_Id);
        Button_delete = view.findViewById(R.id.delete_student_bn);
        Button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletestudent();
            }
        });
        return view;
    }

    private void deletestudent()
    {
        studentDbHelper1 StudentDbHepler=new studentDbHelper1(getActivity());
        SQLiteDatabase database= StudentDbHepler.getWritableDatabase();
        int id=Integer.parseInt(Id.getText().toString());
        StudentDbHepler.Deletestudent(id,database);
        StudentDbHepler.close();
        Id.setText("");
        Toast.makeText(getActivity(),"Student Information Removed Successfully...",Toast.LENGTH_SHORT).show();
    }

}

