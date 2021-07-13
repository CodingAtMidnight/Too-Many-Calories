package com.example.toomanycalories.Dao;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.toomanycalories.entities.Calories;

import java.util.List;

@Dao
public interface CaloriesDao {

    @Query("SELECT * FROM calories")
    List<Calories> selectAllFoods();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFood(Calories calories);

    @Delete
    void deleteFood(Calories calories);


}
