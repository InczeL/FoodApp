package com.example.wheretoeat.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wheretoeat.model.Countries

import com.example.wheretoeat.model.Restaurats
import com.example.wheretoeat.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class RestaurantViewModel(private val repository: Repository) :ViewModel() {
    val myResponse :MutableLiveData<Response<Restaurats>> =MutableLiveData()
    val myResponseCountry :MutableLiveData<Response<Countries>> = MutableLiveData()
    val myResponseCity: MutableLiveData<Response<Restaurats>> = MutableLiveData()
    fun getRestaurantsByCountry(country:String,current_page:Int){
        val launch = viewModelScope.launch {
            val response: Response<Restaurats> = repository.getRestaurantsByCountry(country,current_page)
            myResponse.value = response
        }
    }
    fun getCoutries(){
        val launch = viewModelScope.launch {
            val response: Response<Countries> = repository.getCoutries()
            myResponseCountry.value=response
        }
    }
    fun getRestaurantsByCity(city :String,page:Int){
        val lauch = viewModelScope.launch {
            val response : Response<Restaurats> = repository.getRestaurantsByCity(city,page)
            myResponseCity.value= response
        }
    }

}