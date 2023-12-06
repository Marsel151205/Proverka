package com.marse.domain.models

data class HotelModel(
    val id: Int,
    val name: String,
    val address: String,
    val minimalPrice: Int,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val images: List<String>,
    val aboutTheHotel: AboutTheHotel
)

data class AboutTheHotel(
    val description: String,
    val peculiarities: List<String>
)