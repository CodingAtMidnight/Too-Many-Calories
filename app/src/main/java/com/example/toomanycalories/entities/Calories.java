package com.example.toomanycalories.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "calories")
public class Calories implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int cid;

    @ColumnInfo(name = "food")
    private String food;

    @ColumnInfo(name = "calories_eaten")
    private int caloriesEaten;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getCaloriesEaten() {
        return caloriesEaten;
    }

    public void setCaloriesEaten(int caloriesEaten) {
        this.caloriesEaten = caloriesEaten;
    }

    @NonNull
    @Override
    public String toString() {
        return "You ate the following meal: " + food
                + " and the total calories eaten from this meal were: " +
                caloriesEaten + ".";
    }
}
