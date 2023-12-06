package com.marse.domain.repositories

import com.marse.domain.models.BookingModel
import com.marse.domain.tools.Either
import kotlinx.coroutines.flow.Flow

interface BookingRepository {

    fun getBookingData(): Flow<Either<String, BookingModel>>
}