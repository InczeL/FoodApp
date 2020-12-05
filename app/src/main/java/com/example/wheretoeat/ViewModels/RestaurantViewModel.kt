package com.example.wheretoeat.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wheretoeat.model.Countries
import com.example.wheretoeat.model.Restaurant

import com.example.wheretoeat.model.Restaurats
import com.example.wheretoeat.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class RestaurantViewModel(private val repository: Repository) :ViewModel() {
    val myResponse :MutableLiveData<Response<Restaurats>> =MutableLiveData()
    val myResponseCountri :MutableLiveData<Response<Countries>> = MutableLiveData()
    fun getRestaurantsByCountry(country:String,current_page:Int){
        val launch = viewModelScope.launch {
            val response: Response<Restaurats> = repository.getRestaurantsByCountry(country,current_page)
            myResponse.value = response
        }
    }
    fun getCoutries(){
        val launch = viewModelScope.launch {
            val responseCountrie: Response<Countries> = repository.getCoutries()
            myResponseCountri.value=responseCountrie
        }
    }

}