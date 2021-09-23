package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends weight_tracker {

    public TextView textView_weightProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textView_weightProfile= (TextView) findViewById(R.id.weightText);
        textView_weightProfile.setText(getWeight());

        Button buttonHomeProfile = findViewById(R.id.buttonHomeProfile);
        buttonHomeProfile.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                Intent myIntent = new Intent(profile.this, MainActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(myIntent);

            }
        });


    }


}


