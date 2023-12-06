package com.marse.domain.usecases

import com.marse.domain.repositories.HotelRepository

class HotelUseCase(private val hotelRepository: HotelRepository) {

    operator fun invoke() = hotelRepository.getHotelData()
}