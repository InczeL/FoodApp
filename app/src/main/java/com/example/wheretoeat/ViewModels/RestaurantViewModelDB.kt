package com.example.wheretoeat.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.wheretoeat.model.Restaurant
import com.example.wheretoeat.model.RestaurantDatabase
import com.example.wheretoeat.repository.RestaurantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch

class RestaurantViewModelDB(application: Application):AndroidViewModel(application) {
    private val readAllData :LiveData<List<Restaurant>>
    private val repository :RestaurantRepository

    init{
        val restaurantDao =RestaurantDatabase.getDatabase(application).restaurantDao()
        repository= RestaurantRepository(restaurantDao)
        readAllData = repository.readAllData
    }
    fun addRestaurant(restaurant:Restaurant){
        viewModelScope.launch (Dispatchers.IO){
            repository.addRestaurant(restaurant)
        }
    }
}