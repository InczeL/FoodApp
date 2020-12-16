package com.example.wheretoeat.api




import com.example.wheretoeat.model.Countries
import com.example.wheretoeat.model.Restaurats
import retrofit2.Call
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query


interface RestApiService {
    @GET("restaurants")
    suspend fun  getRestaurantsByCountry(
        @Query("country")country :String,
        @Query("page")page:Int
    ):Response<Restaurats>

    @GET("countries")
    suspend fun  getCoutries():Response<Countries>

    @GET("restaurants")
    suspend fun getRestaurantsByCity(
        @Query("city")city:String,
        @Query("page")page:Int
    ):Response<Restaurats>
}
