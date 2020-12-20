package com.example.wheretoeat.repository

import com.example.wheretoeat.api.RetrofitInstance
import com.example.wheretoeat.model.Cities
import com.example.wheretoeat.model.Restaurats
import retrofit2.Response


class Repository {
    suspend fun getRestaurantsByCountry(page:Int):Response<Restaurats> = RetrofitInstance.api.getRestaurants(page)

    suspend fun  getCities():Response<Cities> = RetrofitInstance.api.getCities()

    suspend fun  getRestaurantsByCity(city : String,page :Int):Response<Restaurats> =
        RetrofitInstance.api.getRestaurantsByCity(city,page)
}