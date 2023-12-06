package com.marsel.presentation.models

import com.marse.domain.models.AboutTheHotel
import com.marse.domain.models.HotelModel


data class HotelModelUI(
    val id: Int,
    val name: String,
    val address: String,
    val minimalPrice: Int,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val images: List<String>,
    val aboutTheHotel: AboutTheHotelModelUI
)

data class AboutTheHotelModelUI(
    val description: String,
    val peculiarities: List<String>
)

fun HotelModel.toUI() = HotelModelUI(
    id = id,
    name = name,
    address = address,
    minimalPrice = minimalPrice,
    priceForIt = priceForIt,
    rating = rating,
    ratingName = ratingName,
    images = images,
    aboutTheHotel = aboutTheHotel.toUI()
)

fun AboutTheHotel.toUI() = AboutTheHotelModelUI(
    description = description,
    peculiarities = peculiarities
)
