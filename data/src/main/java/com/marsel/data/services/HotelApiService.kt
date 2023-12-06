package com.marsel.data.services

import com.marsel.data.remote.dtos.HotelDto
import retrofit2.http.GET

interface HotelApiService {

    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun fetchHotel(): HotelDto
}