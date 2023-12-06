package com.marsel.data.repositories

import com.marse.domain.models.BookingModel
import com.marse.domain.repositories.BookingRepository
import com.marse.domain.tools.Either
import com.marsel.data.base.BaseRepository
import com.marsel.data.remote.dtos.toDomain
import com.marsel.data.services.BookingApiService
import kotlinx.coroutines.flow.Flow

class BookingRepositoryImpl(private val bookingApiService: BookingApiService) : BaseRepository(),
    BookingRepository {
    override fun getBookingData(): Flow<Either<String, BookingModel>> = doRequest {
        bookingApiService.fetchBookingData().toDomain()
    }
}