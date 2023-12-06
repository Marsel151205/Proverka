package com.marse.domain.repositories

import com.marse.domain.models.HotelModel
import com.marse.domain.tools.Either
import kotlinx.coroutines.flow.Flow

interface HotelRepository {

    fun getHotelData(): Flow<Either<String, HotelModel>>
}