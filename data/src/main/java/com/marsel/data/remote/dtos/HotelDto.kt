package com.marsel.data.remote.dtos

import com.google.gson.annotations.SerializedName
import com.marse.domain.models.AboutTheHotel
import com.marse.domain.models.HotelModel

data class HotelDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("adress")
    val address: String,
    @SerializedName("minimal_price")
    val minimalPrice: Int,
    @SerializedName("price_for_it")
    val priceForIt: String,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("rating_name")
    val ratingName: String,
    @SerializedName("image_urls")
    val images: List<String>,
    @SerializedName("about_the_hotel")
    val aboutTheHotel:AboutTheHotelDto
)

data class AboutTheHotelDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("peculiarities")
    val peculiarities: List<String>
)

fun HotelDto.toDomain() = HotelModel(
    id = id,
    name = name,
    address = address,
    minimalPrice = minimalPrice,
    priceForIt = priceForIt,
    rating = rating,
    ratingName = ratingName,
    images = images,
    aboutTheHotel = aboutTheHotel.toDomain()
)

fun AboutTheHotelDto.toDomain() = AboutTheHotel(
    description = description,
    peculiarities = peculiarities
)