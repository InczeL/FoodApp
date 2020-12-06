package com.example.wheretoeat.repository

import com.example.wheretoeat.api.RetrofitInstance
import com.example.wheretoeat.model.Countries
import com.example.wheretoeat.model.Restaurats
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Query

class Repository {
    suspend fun getRestaurantsByCountry(country :String,page:Int):Response<Restaurats> = RetrofitInstance.api.getRestaurantsByCountry(country,page)

    suspend fun  getCoutries():Response<Countries> = RetrofitInstance.api.getCoutries()

    suspend fun  getRestaurantsByCity(city : String,page :Int):Response<Restaurats> =
        RetrofitInstance.api.getRestaurantsByCity(city,page)
}