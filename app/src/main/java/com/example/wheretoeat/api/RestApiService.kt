package com.example.wheretoeat.api




import com.example.wheretoeat.model.Cities
import com.example.wheretoeat.model.Restaurats
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query


interface RestApiService {
    @GET("restaurants")
    suspend fun  getRestaurants(
        @Query("page")page:Int
    ):Response<Restaurats>

    @GET("cities")
    suspend fun  getCities():Response<Cities>

    @GET("restaurants")
    suspend fun getRestaurantsByCity(
        @Query("city")city:String,
        @Query("page")page:Int
    ):Response<Restaurats>
}
