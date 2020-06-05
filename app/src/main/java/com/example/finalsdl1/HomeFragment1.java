package com.example.finalsdl1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.finalsdl1.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment1 extends Fragment implements View.OnClickListener {
      private Button BnSave,BnView,BnDelete,BnUpdate,Apply,studentapplyforintern;
      OnDbOpListener dbOpListener;


    public HomeFragment1() {
        // Required empty public constructor
    }

    public interface OnDbOpListener
    {
        public void dBOpPerformaned(int method);

        void dbOpPerformed(int method);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home1, container, false);
        BnSave = view.findViewById(R.id.bn_save);
        BnSave.setOnClickListener(this);
        BnUpdate=view.findViewById(R.id.bn_update_student);
        BnUpdate.setOnClickListener(this);
        BnView=view.findViewById(R.id.view_student);
        BnView.setOnClickListener(this);
        BnDelete=view.findViewById(R.id.bn_delete_student);
        BnDelete.setOnClickListener(this);
        Apply = view.findViewById(R.id.apply_for_internship);
        Apply.setOnClickListener(this);
        studentapplyforintern=view.findViewById(R.id.apply);
        studentapplyforintern.setOnClickListener(this);





        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.bn_save :
                dbOpListener.dbOpPerformed(0);
                break;

            case R.id.bn_update_student :

                dbOpListener.dbOpPerformed(1);
                break;
            case R.id.view_student :

                dbOpListener.dbOpPerformed(2);
                break;
            case R.id.bn_delete_student:

                dbOpListener.dbOpPerformed(3);
                break;
            case R.id.apply_for_internship:

                dbOpListener.dbOpPerformed(4);
                break;
            case R.id.apply:

                dbOpListener.dbOpPerformed(5);
                break;


        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        try {
            dbOpListener = (OnDbOpListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+" must implement the interfce method");
        }

    }

}
