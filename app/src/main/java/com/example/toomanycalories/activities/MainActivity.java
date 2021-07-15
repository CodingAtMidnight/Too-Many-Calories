package com.example.toomanycalories.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.toomanycalories.R;
import com.example.toomanycalories.database.CaloriesDatabase;
import com.example.toomanycalories.entities.Calories;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CaloriesListAdapter caloriesListAdapter;
    private TextView totalCalories;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clearCalories = findViewById(R.id.clearAllCalories);
        Button addCalories = findViewById(R.id.addCalories);
        totalCalories = findViewById(R.id.totalCalories);
        addCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        new Intent(getApplicationContext(), AddCalorieActivity.class),
                        100
                );
            }
        });

        clearCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAllCalories();
            }
        });

        totalCalories.setText(getTotalCalories());

        initRecyclerReview();
        loadCaloriesList();


    }


    private void initRecyclerReview() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        caloriesListAdapter = new CaloriesListAdapter(this);
        recyclerView.setAdapter(caloriesListAdapter);
    }



    private void loadCaloriesList() {
        CaloriesDatabase db = CaloriesDatabase.getCaloriesDatabase(this.getApplicationContext());
        List<Calories> caloriesList = db.caloriesDao().selectAllFoods();
        caloriesListAdapter.setCaloriesList(caloriesList);
    }


    private String getTotalCalories() {
        CaloriesDatabase db = CaloriesDatabase.getCaloriesDatabase(this.getApplicationContext());
        List<Calories> caloriesList = db.caloriesDao().selectAllFoods();
        int sum = 0;
        int[] caloriesEaten = new int[caloriesList.size()];
        for (int i = 0; i < caloriesList.size(); i++) {
           sum += caloriesList.get(i).getCaloriesEaten();
        }

        return String.valueOf(sum);
    }

    //TODO
    private void deleteAllCalories() {
        CaloriesDatabase db = CaloriesDatabase.getCaloriesDatabase(this.getApplicationContext());
        List<Calories> caloriesList = db.caloriesDao().selectAllFoods();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            loadCaloriesList();
            totalCalories.setText(getTotalCalories());

        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}