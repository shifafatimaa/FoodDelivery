package com.example.fooddelivery.model

import androidx.compose.runtime.MutableState

data class Restaurant(
    val name: String,
    val type: String,
    val rating: Double,
    val minTime: Int, // in minutes
    var isFavorite: MutableState<Boolean>
)
