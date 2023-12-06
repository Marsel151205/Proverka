package com.marse.domain.models

data class BookingModel(
    val id: Int,
    val hotelName: String,
    val hotelAddress: String,
    val rating: Int,
    val ratingName: String,
    val departure: String,
    val arrivalCountry: String,
    val dateStart: String,
    val dateStop: String,
    val numberOfNights: Int,
    val room: String,
    val nutrition: String,
    val price: Int,
    val fuelCharge: Int,
    val serviceCharge: Int
)
