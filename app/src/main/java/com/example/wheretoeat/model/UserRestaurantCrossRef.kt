package com.example.wheretoeat.model

import androidx.room.Entity

@Entity(primaryKeys = ["userId","restaurantId"])
data class UserRestaurantCrossRef (
    val userId :Int,
    val restaurantId :Int
        )