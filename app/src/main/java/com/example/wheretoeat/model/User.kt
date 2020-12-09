package com.example.wheretoeat.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data  class User(
    @PrimaryKey(autoGenerate = false)
    val name : String,
    val password :String,
    val address : String,
    val phone_number : String,
    val email : String
    )
