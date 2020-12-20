package com.example.wheretoeat.ViewModels

import androidx.lifecycle.ViewModel
import com.example.wheretoeat.database.Restaurant
import com.example.wheretoeat.database.User

class ProfileViewModel: ViewModel() {
    private var favorits: ArrayList<Restaurant> = arrayListOf()
    val user = User(1,"Incze","jelszo","Virag utca 2","0758964312","incze@gmail.com")
    fun getFavorits()= favorits
    fun addFavorit(v_restaurant:Restaurant) = favorits.add(v_restaurant)
    fun removeFavorit(v_restaurant: Restaurant) = favorits.remove(v_restaurant)
}