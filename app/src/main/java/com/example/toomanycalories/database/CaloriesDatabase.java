package com.example.toomanycalories.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.toomanycalories.Dao.CaloriesDao;
import com.example.toomanycalories.entities.Calories;

@Database(entities = {Calories.class}, version = 1 , exportSchema = false)
public abstract class CaloriesDatabase extends RoomDatabase {
    private static CaloriesDatabase caloriesDatabase;

    public static synchronized CaloriesDatabase getCaloriesDatabase(Context context) {
        if (caloriesDatabase == null) {
            caloriesDatabase = Room.databaseBuilder(
                    context,
                    CaloriesDatabase.class,
                    "food_db"
            ).build();
        }
        return caloriesDatabase;
    }
    public abstract CaloriesDao caloriesDao();
}
