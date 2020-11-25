package com.example.wheretoeat.model

data class Restaurats(
    val count: Int,
    val current_page: Int,
    val per_page: Int,
    val restaurants: List<Restaurant>
)