package com.example.finalsdl1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.finalsdl1.R;

public class MainActivity1 extends AppCompatActivity implements com.example.finalsdl1.HomeFragment1.OnDbOpListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            com.example.finalsdl1.HomeFragment1 homeFragment = new com.example.finalsdl1.HomeFragment1();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment).commit();

        }
    }

    @Override
    public void dBOpPerformaned(int method) {

    }

    @Override
    public void dbOpPerformed(int method) {
        switch (method) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.finalsdl1.AddstudentFragment1()).addToBackStack(null).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.finalsdl1.UpdatestudentFragment1()).addToBackStack(null).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.finalsdl1.ViewstudentFragment1()).addToBackStack(null).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.finalsdl1.DeletestudentFragment1()).addToBackStack(null).commit();
                break;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.finalsdl1.ReadInternshipFragment()).addToBackStack(null).commit();
                break;
            case 5:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.finalsdl1.studentapplyfragment()).addToBackStack(null).commit();
                break;


        }
    }
}








