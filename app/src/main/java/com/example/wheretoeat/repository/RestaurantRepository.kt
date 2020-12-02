package com.example.wheretoeat.repository

import androidx.lifecycle.LiveData
import com.example.wheretoeat.model.Restaurant
import com.example.wheretoeat.model.RestaurantDao

class RestaurantRepository(private val restaurantDao: RestaurantDao) {
    val readAllData:LiveData<List<Restaurant>> = restaurantDao.readAllData()

    suspend fun addRestaurant(restaurant :Restaurant){
        restaurantDao.addRestaurant(restaurant)
    }
}