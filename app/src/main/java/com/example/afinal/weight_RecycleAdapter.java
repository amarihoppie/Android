package com.example.afinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class weight_RecycleAdapter extends RecyclerView.Adapter<weight_RecycleAdapter.ViewHolder>  {

    private List<String> weightList;
    private List<String> dateList;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_date;
        public TextView textView_weight;
        public TextView textView_weightplacer;
        public TextView textView_datplacer;

        public ViewHolder(View view) {
            super(view);
            textView_date= (TextView) view.findViewById(R.id.textView_date);
            textView_weight= (TextView) view.findViewById(R.id.textView_weight);
            textView_weightplacer = (TextView) view.findViewById(R.id.textView_weightplacer);
            textView_datplacer = (TextView) view.findViewById(R.id.textView_datplacer);

        }}


    public weight_RecycleAdapter(List<String> weightList, List<String> dateList) {
        this.weightList = weightList;
        this.dateList = dateList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.weight_recycle, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String weight = weightList.get(position);
        String date = dateList.get(position);

        holder.textView_date.setText(date);
        holder.textView_weight.setText(weight);

    }

    @Override
    public int getItemCount() {
        return weightList.size();
    }

    public void setData(List<String> weightList, List<String> dateList) {
        this.weightList = weightList;
        this.dateList = dateList;

        notifyDataSetChanged();
    }

}