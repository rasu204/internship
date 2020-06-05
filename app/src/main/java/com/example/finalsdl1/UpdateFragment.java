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


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {
    private EditText update_company_name,update_activity,update_activity_id,update_title,update_start_date,update_duration,update_stipend,update_description;
    private Button Update_bn;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);
        update_company_name=view.findViewById(R.id.text_updatecompany_name);
        update_activity=view.findViewById(R.id.text_updateactivity);
        update_activity_id=view.findViewById(R.id.text_updateactivity_id);
        update_title=view.findViewById(R.id.text_updatetitle);
        update_start_date=view.findViewById(R.id.text_updatestart_date);
        update_duration=view.findViewById(R.id.text_updateduration);
        update_stipend=view.findViewById(R.id.text_updatestipend);
        update_description=view.findViewById(R.id.text_updatedescription);

        Update_bn=view.findViewById(R.id.bn_update_save);
        Update_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateInternship();

            }
        });
        return view;
    }
    private void updateInternship()
    {

        String company_name=update_company_name.getText().toString();
        String activity=update_activity.getText().toString();
        int activity_id=Integer.parseInt(update_activity_id.getText().toString());
        String title=update_title.getText().toString();
        String start_date=update_start_date.getText().toString();
        int duration=Integer.parseInt(update_duration.getText().toString());
        int stipend=Integer.parseInt(update_stipend.getText().toString());
        String description=update_description.getText().toString();

        InternshipDbHelper internshipDbHelper=new InternshipDbHelper(getActivity());
        SQLiteDatabase database=internshipDbHelper.getWritableDatabase();
        internshipDbHelper.updateInternship(company_name,activity,activity_id,title,start_date,duration,stipend,description,database);
        internshipDbHelper.close();
        Toast.makeText(getActivity(),"Internship Updated...",Toast.LENGTH_SHORT).show();
        update_company_name.setText("");
        update_activity.setText("");
        update_activity_id.setText("");
        update_title.setText("");
        update_start_date.setText("");
        update_duration.setText("");
        update_stipend.setText("");
        update_description.setText("");

    }


}
