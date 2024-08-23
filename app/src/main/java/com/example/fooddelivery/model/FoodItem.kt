package com.example.fooddelivery.model

import androidx.compose.runtime.MutableState

data class FoodItem(
    val name: String,
    val type: String,
    val price: Double,
    val isFavorite: MutableState<Boolean>,
    val rating: Double,
    val minTime: Int,
    val imageResId: Int
)
