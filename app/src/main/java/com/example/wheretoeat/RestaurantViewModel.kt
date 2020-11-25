package com.example.wheretoeat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.wheretoeat.model.Restaurats
import com.example.wheretoeat.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class RestaurantViewModel(private val repository: Repository) :ViewModel() {
    val myResponse :MutableLiveData<Call<Restaurats>> =MutableLiveData()

    fun getRestaurants(){
        val launch = viewModelScope.launch {
            val response: Call<Restaurats> = repository.getRestaurants()
            myResponse.value = response
        }
    }
}