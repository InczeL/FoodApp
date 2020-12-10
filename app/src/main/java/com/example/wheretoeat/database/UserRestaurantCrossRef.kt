package com.example.wheretoeat.database

import androidx.room.Entity

@Entity(primaryKeys = ["userId","restaurantId"])
data class UserRestaurantCrossRef (
    val userId :Int,
    val restaurantId :Int
        )