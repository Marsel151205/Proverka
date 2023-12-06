package com.marsel.presentation.models

import com.marse.domain.models.BookingModel

data class BookingModelUI(
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

fun BookingModel.toUI() = BookingModelUI(
    id = id,
    hotelName = hotelName,
    hotelAddress = hotelAddress,
    rating = rating,
    ratingName = ratingName,
    departure = departure,
    arrivalCountry = arrivalCountry,
    dateStart = dateStart,
    dateStop = dateStop,
    numberOfNights = numberOfNights,
    room = room,
    nutrition = nutrition,
    price = price,
    fuelCharge = fuelCharge,
    serviceCharge = serviceCharge
)