package com.example.wheretoeat.api




import com.example.wheretoeat.model.Restaurats
import retrofit2.Call
import retrofit2.Response

import retrofit2.http.GET



interface RestApiService {
    @GET("/api/restaurants")
    fun getRestaurants(): Call<Restaurats>
}
