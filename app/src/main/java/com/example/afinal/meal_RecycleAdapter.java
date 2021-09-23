package com.example.afinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class meal_RecycleAdapter extends RecyclerView.Adapter<meal_RecycleAdapter.ViewHolder>  {

    private List<String> mealList;
    private List<String> calorieList;
    private List<String> categoryList;



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_Meal;
        public TextView textView_Calorie;
        public TextView textView_Calorieplacer;
        public TextView textView_Mealplacer;
        public TextView textView_Category;
        public TextView textView_Categoryplacer;

        public ViewHolder(View view) {
            super(view);
            textView_Meal= (TextView) view.findViewById(R.id.textView_Meal);
            textView_Calorie= (TextView) view.findViewById(R.id.textView_Calorie);
            textView_Calorieplacer = (TextView) view.findViewById(R.id.textView_Calorieplacer);
            textView_Mealplacer = (TextView) view.findViewById(R.id.textView_Mealplacer);
            textView_Category= (TextView) view.findViewById(R.id.textView_Category);
            textView_Categoryplacer= (TextView) view.findViewById(R.id.textView_Categoryplacer);

        }}


    public meal_RecycleAdapter(List<String> mealList, List<String> calorieList, List<String> categoryList) {
        this.mealList = mealList;
        this.calorieList = calorieList;
        this.categoryList = categoryList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_recycle, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String meal = mealList.get(position);
        String calorie = calorieList.get(position);
        String category = categoryList.get(position);
        holder.textView_Meal.setText(meal);
        holder.textView_Calorie.setText(calorie);
        holder.textView_Category.setText(category);
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public void setData(List<String> mealList, List<String> calorieList,  List<String> categoryList) {
        this.mealList = mealList;
        this.calorieList = calorieList;
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }

}