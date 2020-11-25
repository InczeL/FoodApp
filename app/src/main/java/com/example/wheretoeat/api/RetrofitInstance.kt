package com.example.wheretoeat.api

import com.example.wheretoeat.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api :RestApiService by lazy {
        retrofit.create(RestApiService::class.java)
    }
}