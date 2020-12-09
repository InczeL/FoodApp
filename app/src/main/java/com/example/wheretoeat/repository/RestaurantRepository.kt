package com.example.wheretoeat.repository

import androidx.lifecycle.LiveData
import com.example.wheretoeat.model.Restaurant
import com.example.wheretoeat.model.RestaurantDao
import com.example.wheretoeat.model.User

class RestaurantRepository(private val restaurantDao: RestaurantDao) {
    private lateinit var user: User

    suspend fun addRestaurant(restaurant :Restaurant){
        restaurantDao.addRestaurant(restaurant)
    }
    suspend fun addUser(user: User){
        restaurantDao.addUser(user)
    }
    suspend fun  getUser(p_name:String):User{
        user= restaurantDao.getUser(p_name)
        return user
    }
}