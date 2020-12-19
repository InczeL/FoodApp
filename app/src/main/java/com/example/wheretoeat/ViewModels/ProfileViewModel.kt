package com.example.wheretoeat.ViewModels

import androidx.lifecycle.ViewModel
import com.example.wheretoeat.database.Restaurant
import com.example.wheretoeat.database.User

class ProfileViewModel: ViewModel() {
    private var favorits: List<Restaurant> = mutableListOf()
    val user = User(1,"Incze","jelszo","Virag utca 2","0758964312","incze@gmail.com")
    fun getFavorits()= favorits
    fun addFavorit(v_restaurant:Restaurant) = favorits.toMutableList().add(v_restaurant)
    fun removeFavorit(v_restaurant: Restaurant) = favorits.toMutableList().remove(v_restaurant)
}