package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class weight_tracker extends AppCompatActivity {

   // DatabaseHelper mDatabaseHelper;
    private Button button_weight;
    private Button button_homeWeight;
    private EditText editText_currentWeight;
    private EditText editText_date;
    private EditText editText_BMI;
    private Spinner spinner_month;
    private Spinner spinner_day;
    private Spinner spinner_year;
    private TextView textView_date;
    private RecyclerView weight_recycle;
    private weight_RecycleAdapter mAdapter;
    protected List<String> weightList = new ArrayList<>();;
    protected List<String> dateList = new ArrayList<>();;
    String d = "";
    String w = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker);

        EditText editText_currentWeight = findViewById(R.id.editText_currentWeight);
        EditText editText_date = findViewById(R.id.editText_date);

        weight_recycle = (RecyclerView) findViewById(R.id.weight_recycle);
        mAdapter = new weight_RecycleAdapter((weightList),(dateList));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        weight_recycle.setLayoutManager(mLayoutManager);
        weight_recycle.setItemAnimator(new DefaultItemAnimator());
        weight_recycle.setAdapter(mAdapter);

        dateList.add("4/20/2020");
        weightList.add("141.1");

        mAdapter.notifyDataSetChanged();

        Button button_weight = findViewById(R.id.button_weight);
        button_weight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               EditText editText_currentWeight = findViewById(R.id.editText_currentWeight);
                EditText editText_date = findViewById(R.id.editText_date);

                 d =  editText_date.getText().toString();
                 w =  editText_currentWeight.getText().toString();

                dateList.add(d); weightList.add(w);

            }
        });


        Button buttonHomeWeight = findViewById(R.id.buttonHomeWeight);
        buttonHomeWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(weight_tracker.this, MainActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(myIntent);

            }});


    }
    public String getWeight(){

        return weightList.get(weightList.size() - 1);
    }


}
