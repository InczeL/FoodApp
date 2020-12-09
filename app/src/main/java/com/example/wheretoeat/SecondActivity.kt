package com.example.wheretoeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.wheretoeat.ViewModels.RestaurantViewModel
import com.example.wheretoeat.ViewModels.RestaurantViewModelDB
import com.example.wheretoeat.model.RestaurantDao
import com.example.wheretoeat.model.RestaurantDatabase

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val dbViewModel:RestaurantViewModelDB by viewModels()
    }
}