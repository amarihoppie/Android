package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class Fitness extends AppCompatActivity {
    private RecyclerView exercise_recycler;
    private fitness_RecycleAdapter mAdapter;

    int e = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        Button button_test = findViewById(R.id.buttonHomeExercise);
        button_test.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        if(e == 0) {
            final List<String> exerciseList = new ArrayList<>();
            ;
            final List<String> repList = new ArrayList<>();
            ;
            final List<String> setList = new ArrayList<>();
            ;
            final List<String> weightUsedList = new ArrayList<>();
            ;

            EditText editText_Exercise = findViewById(R.id.editText_Exercise);
            EditText editText_Reps = findViewById(R.id.editText_Reps);
            EditText editText_Sets = findViewById(R.id.editText_Sets);
            EditText editText_WeightUsed = findViewById(R.id.editText_WeightUsed);

            exercise_recycler = (RecyclerView) findViewById(R.id.exercise_recycler);


            mAdapter = new fitness_RecycleAdapter((exerciseList), (repList), (setList), (weightUsedList));

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            exercise_recycler.setLayoutManager(mLayoutManager);
            exercise_recycler.setItemAnimator(new DefaultItemAnimator());
            exercise_recycler.setAdapter(mAdapter);


            exerciseList.add("Bicep Curls");
            repList.add("10");
            setList.add("3");
            weightUsedList.add("30");

            mAdapter.notifyDataSetChanged();

            Button buttonAddFitness = findViewById(R.id.buttonAddFitness);
            buttonAddFitness.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    EditText editText_Exercise = findViewById(R.id.editText_Exercise);
                    EditText editText_Reps = findViewById(R.id.editText_Reps);
                    EditText editText_Sets = findViewById(R.id.editText_Sets);
                    EditText editText_WeightUsed = findViewById(R.id.editText_WeightUsed);

                    String e = editText_Exercise.getText().toString();
                    String r = editText_Reps.getText().toString();
                    String s = editText_Sets.getText().toString();
                    String wU = editText_WeightUsed.getText().toString();
                    exerciseList.add(e);
                    repList.add(r);
                    setList.add(s);
                    weightUsedList.add(wU);

                }
            });
        }
        /*
        Reps are Weight Used and vice versa!!!
         */
            Button buttonHomeExercise = findViewById(R.id.buttonHomeExercise);
        buttonHomeExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent myIntent = new Intent(Fitness.this, MainActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(myIntent);

*/
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                e = 1;

            }});


    }

}

