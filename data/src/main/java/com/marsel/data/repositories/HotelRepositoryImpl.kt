package com.marsel.data.repositories

import com.marse.domain.models.HotelModel
import com.marse.domain.repositories.HotelRepository
import com.marse.domain.tools.Either
import com.marsel.data.base.BaseRepository
import com.marsel.data.remote.dtos.toDomain
import com.marsel.data.services.HotelApiService
import kotlinx.coroutines.flow.Flow

class HotelRepositoryImpl(private val hotelApiService: HotelApiService) : HotelRepository,
    BaseRepository() {

    override fun getHotelData(): Flow<Either<String, HotelModel>> = doRequest{
        hotelApiService.fetchHotel().toDomain()
    }
}