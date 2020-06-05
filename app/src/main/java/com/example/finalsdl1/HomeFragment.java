package com.example.finalsdl1;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener
{
    private Button BnSave,BnView,BnCancel,BnUpdate;
    OnDbOpListener dbOpListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnDbOpListener{

        public void dbOpPerformed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        BnSave = view.findViewById(R.id.add_internship);
        BnSave.setOnClickListener(this);
        BnView=view.findViewById(R.id.view_internship);
        BnView.setOnClickListener(this);
        BnUpdate=view.findViewById(R.id.update_internship);
        BnUpdate.setOnClickListener(this);
        BnCancel=view.findViewById(R.id.cancel_internship);
        BnCancel.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_internship:
                dbOpListener.dbOpPerformed(0);
                break;
            case R.id.view_internship:

                dbOpListener.dbOpPerformed(1);
                break;
            case R.id.update_internship :

                dbOpListener.dbOpPerformed(2);
                break;
            case R.id.cancel_internship:

                dbOpListener.dbOpPerformed(3);
                break;


        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity =(Activity) context;
        try {
            dbOpListener = (OnDbOpListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+"must implement the interface method");
        }
    }

}
