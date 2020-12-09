package com.example.wheretoeat.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserRestaurants (
    @Embedded  val user: User,
    @Relation (
        parentColumn = "userId",
        entityColumn = "id",
        associateBy = Junction(UserRestaurantCrossRef::class)
            ) val restaurants :List<Restaurant>
        )
