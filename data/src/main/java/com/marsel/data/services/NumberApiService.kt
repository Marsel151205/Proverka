package com.marsel.data.services

import com.marsel.data.remote.dtos.NumberDto
import com.marsel.data.remote.dtos.NumberResponse
import retrofit2.http.GET

interface NumberApiService {

    @GET("8b532701-709e-4194-a41c-1a903af00195")
    suspend fun fetchNumbers(): NumberResponse
}