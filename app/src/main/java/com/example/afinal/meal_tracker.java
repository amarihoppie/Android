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

import java.util.ArrayList;
import java.util.List;

public class meal_tracker extends AppCompatActivity {
    private RecyclerView meal_recycle;
    private meal_RecycleAdapter mAdapter;

    protected List<String> mealList = new ArrayList<>();;
    protected List<String> calorieList = new ArrayList<>();;
    protected List<String> categoryList = new ArrayList<>();;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_meal_tracker);

            EditText editText_Meal = findViewById(R.id.editText_Meal);
            EditText editText_Calorie = findViewById(R.id.editText_Calorie);
            EditText editText_Category = findViewById(R.id.editText_Category);

            meal_recycle = (RecyclerView) findViewById(R.id.meal_recycler);
            mAdapter = new meal_RecycleAdapter((mealList),(calorieList),(categoryList));
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            meal_recycle.setNestedScrollingEnabled(true);

            meal_recycle.setLayoutManager(mLayoutManager);
            meal_recycle.setItemAnimator(new DefaultItemAnimator());
            meal_recycle.setAdapter(mAdapter);

            mealList.add("Omelette"); calorieList.add("120");
            categoryList.add("Breakfast");
            mealList.add("Turkey Sandwich"); calorieList.add("310");
            categoryList.add("Lunch");

            mAdapter.notifyDataSetChanged();

            Button button_mealAdd = findViewById(R.id.button_mealAdd);
            button_mealAdd.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    EditText editText_Meal = findViewById(R.id.editText_Meal);
                    EditText editText_Calorie = findViewById(R.id.editText_Calorie);
                    EditText editText_Category = findViewById(R.id.editText_Category);

                    String m =  editText_Meal.getText().toString();
                    String cal =  editText_Calorie.getText().toString();
                    String cat = editText_Category.getText().toString();
                    mealList.add(m);  calorieList.add(cal);
                    categoryList.add(cat);


                }
            });

        Button buttonHomeExercise = findViewById(R.id.buttonHomeMeal);
        buttonHomeExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(meal_tracker.this, MainActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(myIntent);

            }});

        }
    }
