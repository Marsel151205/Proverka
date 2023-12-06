package com.marsel.data.remote.dtos

import com.google.gson.annotations.SerializedName
import com.marse.domain.models.BookingModel

data class BookingDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("hotel_name")
    val hotelName: String,
    @SerializedName("hotel_adress")
    val hotelAddress: String,
    @SerializedName("horating")
    val rating: Int,
    @SerializedName("rating_name")
    val ratingName: String,
    @SerializedName("departure")
    val departure: String,
    @SerializedName("arrival_country")
    val arrivalCountry: String,
    @SerializedName("tour_date_start")
    val dateStart: String,
    @SerializedName("tour_date_stop")
    val dateStop: String,
    @SerializedName("number_of_nights")
    val numberOfNights: Int,
    @SerializedName("room")
    val room: String,
    @SerializedName("nutrition")
    val nutrition: String,
    @SerializedName("tour_price")
    val price: Int,
    @SerializedName("fuel_charge")
    val fuelCharge: Int,
    @SerializedName("service_charge")
    val serviceCharge: Int
)

fun BookingDto.toDomain() = BookingModel(
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
