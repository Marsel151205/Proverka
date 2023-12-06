package com.marse.domain.usecases

import com.marse.domain.repositories.BookingRepository

class BookingUseCase(private val bookingRepository: BookingRepository) {

    operator fun invoke() = bookingRepository.getBookingData()
}