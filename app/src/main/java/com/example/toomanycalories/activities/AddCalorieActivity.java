package com.example.toomanycalories.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.toomanycalories.R;
import com.example.toomanycalories.database.CaloriesDatabase;
import com.example.toomanycalories.entities.Calories;

public class AddCalorieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_calorie);


        EditText enterFood = findViewById(R.id.foodName);
        EditText enterCalories = findViewById(R.id.numberOfCalories);
        Button inputFood = findViewById(R.id.inputFood);


        Button goBack = findViewById(R.id.goBack);





        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        inputFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewFood(enterFood.getText().toString(), Integer.parseInt(enterCalories.getText().toString()));
            }
        });
    }


    private void saveNewFood(String foodName, int caloriesNumber) {
        CaloriesDatabase db = CaloriesDatabase.getCaloriesDatabase(this.getApplicationContext());

        Calories calories = new Calories();
        calories.setFood(foodName);
        calories.setCaloriesEaten(caloriesNumber);

        db.caloriesDao().insertFood(calories);

        finish();
    }

}