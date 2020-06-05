package com.example.finalsdl1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyData extends AppCompatActivity implements HomeFragment.OnDbOpListener  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_data);

        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,homeFragment).commit();
        }
    }

    @Override
    public void dbOpPerformed(int method)
    {
        switch (method){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ApplyFragment()).addToBackStack(null).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ReadInternshipFragment()).addToBackStack(null).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UpdateFragment()).addToBackStack(null).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DeleteInternshipFragment()).addToBackStack(null).commit();
                break;
        }

    }

}
