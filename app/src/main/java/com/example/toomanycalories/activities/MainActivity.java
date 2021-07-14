package com.example.toomanycalories.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.toomanycalories.R;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_ADD_CALORIES = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addCalories = findViewById(R.id.addCalories);
        addCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        new Intent(getApplicationContext(), AddCalorieActivity.class),
                        REQUEST_CODE_ADD_CALORIES
                );
            }
        });
    }
}