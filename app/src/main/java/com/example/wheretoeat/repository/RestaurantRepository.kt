package com.example.wheretoeat.repository

import com.example.wheretoeat.database.Restaurant
import com.example.wheretoeat.database.RestaurantDao
import com.example.wheretoeat.database.User

class RestaurantRepository(private val restaurantDao: RestaurantDao) {
    private lateinit var user: User

    suspend fun addRestaurant(restaurant : Restaurant){
        restaurantDao.addRestaurant(restaurant)
    }
    suspend fun addUser(user: User){
        restaurantDao.addUser(user)
    }
    suspend fun  getUser(p_name:String): User {
        user= restaurantDao.getUser(p_name)
        return user
    }
}