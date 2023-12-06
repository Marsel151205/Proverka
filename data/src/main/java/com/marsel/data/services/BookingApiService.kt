package com.marsel.data.services

import com.marsel.data.remote.dtos.BookingDto
import retrofit2.http.GET

interface BookingApiService {

    @GET("63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun fetchBookingData(): BookingDto
}