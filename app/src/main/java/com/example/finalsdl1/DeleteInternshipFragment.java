package com.example.finalsdl1;


import android.app.Activity;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteInternshipFragment extends Fragment {

    private EditText Activity_id;
    private Button Button_Delete;
    public DeleteInternshipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete_internship, container, false);
        Activity_id=view.findViewById(R.id.editTextxt_delete_activity_id);
        Button_Delete=view.findViewById(R.id.delete_internship_bn);
        Button_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteInternship();
            }
        });
        return view;
    }

    private void deleteInternship()
    {

        InternshipDbHelper internshipDbHelper=new InternshipDbHelper(getActivity());
        SQLiteDatabase database= internshipDbHelper.getWritableDatabase();
        int activity_id=Integer.parseInt(Activity_id.getText().toString());
        internshipDbHelper.deleteInternship(activity_id,database);
        internshipDbHelper.close();
        Activity_id.setText("");
        Toast.makeText(getActivity(),"Internship Removed Successfully...",Toast.LENGTH_SHORT).show();
    }

}
