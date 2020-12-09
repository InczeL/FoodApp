package com.example.wheretoeat.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.wheretoeat.model.Restaurant
import com.example.wheretoeat.model.RestaurantDatabase
import com.example.wheretoeat.model.User
import com.example.wheretoeat.repository.RestaurantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch

class RestaurantViewModelDB(application: Application):AndroidViewModel(application) {
    private  lateinit var user:User
    private val repository :RestaurantRepository

    init{
        val restaurantDao =RestaurantDatabase.getDatabase(application).restaurantDao()
        repository= RestaurantRepository(restaurantDao)
    }
    fun addRestaurant(restaurant:Restaurant){
        viewModelScope.launch (Dispatchers.IO){
            repository.addRestaurant(restaurant)
        }
    }
    fun addUser(user :User){
        viewModelScope.launch (Dispatchers.IO){
            repository.addUser(user)
        }
    }
    fun getUser(p_name :String):User{
        viewModelScope.launch { (Dispatchers.IO){
            user = repository.getUser(p_name)
        } }
        return  user
    }
}