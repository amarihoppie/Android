package com.example.afinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class fitness_RecycleAdapter extends RecyclerView.Adapter<fitness_RecycleAdapter.ViewHolder>  {

    private List<String> exerciseList;
    private List<String> repList;
    private List<String> weightUsedList;
    private List<String> setList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_exercise;
        public TextView textView_weightUsed;
        public TextView textView_sets;
        public TextView textView_reps;
        public TextView textView_exercisePlacer;
        public TextView textView_setplacer;
        public TextView textView_weightPlacer;
        public TextView textView_repsplacer;
        public ViewHolder(View view) {
            super(view);
            textView_exercise= (TextView) view.findViewById(R.id.textView_exercise);
            textView_weightUsed= (TextView) view.findViewById(R.id.textView_weightUsed);
            textView_sets = (TextView) view.findViewById(R.id.textView_sets);
            textView_reps = (TextView) view.findViewById(R.id.textView_reps);
            textView_exercisePlacer= (TextView) view.findViewById(R.id.textView_exercisePlacer);
            textView_weightPlacer= (TextView) view.findViewById(R.id.textView_weightPlacer);
            textView_setplacer = (TextView) view.findViewById(R.id.textView_setplacer);
            textView_repsplacer = (TextView) view.findViewById(R.id.textView_repsplacer);

        }}


    public fitness_RecycleAdapter(List<String> exerciseList, List<String> repList, List<String> setList, List<String> weightUsedList) {
        this.exerciseList = exerciseList;
        this.repList = repList;
        this.setList = setList;
        this.weightUsedList = weightUsedList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_recycle, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String exercise = exerciseList.get(position);
        String rep = repList.get(position);
        String set = setList.get(position);
        String weightUsed = weightUsedList.get(position);

        holder.textView_exercise.setText(exercise);
        holder.textView_weightUsed.setText(rep);
        holder.textView_sets.setText(set);
        holder.textView_reps.setText(weightUsed);

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public void setData(List<String> weightList, List<String> dateList) {
        this.exerciseList = exerciseList;
        this.repList = repList;
        this.setList = setList;
        this.weightUsedList = weightUsedList;
        notifyDataSetChanged();
    }

}