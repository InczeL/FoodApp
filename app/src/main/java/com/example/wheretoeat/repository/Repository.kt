package com.example.wheretoeat.repository

import com.example.wheretoeat.api.RetrofitInstance
import com.example.wheretoeat.model.Restaurats
import retrofit2.Call
import retrofit2.Response

class Repository {
    suspend fun getRestaurants(): Call<Restaurats> {
        return RetrofitInstance.api.getRestaurants()
    }
}