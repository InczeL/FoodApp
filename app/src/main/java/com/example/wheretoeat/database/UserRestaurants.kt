package com.example.wheretoeat.database

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.wheretoeat.database.Restaurant
import com.example.wheretoeat.database.User
import com.example.wheretoeat.database.UserRestaurantCrossRef

data class UserRestaurants (
    @Embedded  val user: User,
    @Relation (
        parentColumn = "userId",
        entityColumn = "id",
        associateBy = Junction(UserRestaurantCrossRef::class)
            ) val restaurants :List<Restaurant>
        )
