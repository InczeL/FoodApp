package com.example.wheretoeat.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wheretoeat.model.Cities

import com.example.wheretoeat.model.Restaurats
import com.example.wheretoeat.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class RestaurantViewModel(private val repository: Repository) :ViewModel() {
    val myResponse :MutableLiveData<Response<Restaurats>> =MutableLiveData()
    val myResponseCities :MutableLiveData<Response<Cities>> = MutableLiveData()
    val myResponseCity: MutableLiveData<Response<Restaurats>> = MutableLiveData()
    fun getRestaurants(current_page:Int){
        val launch = viewModelScope.launch {
            val response: Response<Restaurats> = repository.getRestaurantsByCountry(current_page)
            myResponse.value = response
        }
    }
    fun getCities(){
        val launch = viewModelScope.launch {
            val response: Response<Cities> = repository.getCities()
            myResponseCities.value=response
        }
    }
    fun getRestaurantsByCity(city :String,page:Int){
        val lauch = viewModelScope.launch {
            val response : Response<Restaurats> = repository.getRestaurantsByCity(city,page)
            myResponseCity.value= response
        }
    }

}