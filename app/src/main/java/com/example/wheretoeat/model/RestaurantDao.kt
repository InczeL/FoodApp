package com.example.wheretoeat.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun addRestaurant(restaurant :Restaurant)

    @Query("SELECT * FROM restaurant_table")
    fun readAllData():LiveData<List<Restaurant>>
}