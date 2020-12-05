package com.example.wheretoeat.model

data class Restaurats(
    val total_entries: Int,
    val per_page: Int,
    val current_page: Int,
    val restaurants: List<Restaurant>
)