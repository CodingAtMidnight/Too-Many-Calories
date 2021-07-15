package com.example.toomanycalories.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.toomanycalories.Dao.CaloriesDao;
import com.example.toomanycalories.entities.Calories;

@Database(entities = {Calories.class}, version = 1 , exportSchema = false)
public abstract class CaloriesDatabase extends RoomDatabase {
    public abstract CaloriesDao caloriesDao();

    private static CaloriesDatabase INSTANCE;

    public static  CaloriesDatabase getCaloriesDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    CaloriesDatabase.class,
                    "food_db"
            ).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}
