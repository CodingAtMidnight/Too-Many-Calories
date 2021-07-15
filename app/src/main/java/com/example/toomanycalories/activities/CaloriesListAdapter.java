package com.example.toomanycalories.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toomanycalories.R;
import com.example.toomanycalories.entities.Calories;


import java.util.List;

public class CaloriesListAdapter extends RecyclerView.Adapter<CaloriesListAdapter.MyViewHolder> {

    private final Context context;
    private List<Calories> caloriesList;

    public CaloriesListAdapter(Context context) {
        this.context = context;
    }

    public void setCaloriesList(List<Calories> caloriesList) {
        this.caloriesList = caloriesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CaloriesListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CaloriesListAdapter.MyViewHolder holder, int position) {
        holder.foodDisplay.setText(this.caloriesList.get(position).getFood());
        holder.caloriesDisplay.setText(String.valueOf(this.caloriesList.get(position).getCaloriesEaten()));
    }

    @Override
    public int getItemCount() {
        return this.caloriesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView foodDisplay;
        TextView caloriesDisplay;

        public MyViewHolder(View view) {
            super(view);
            foodDisplay = view.findViewById(R.id.foodNameDisplay);
            caloriesDisplay = view.findViewById(R.id.caloriesDisplay);
        }
    }
}
