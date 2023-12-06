package com.marse.domain.usecases

import com.marse.domain.repositories.NumberRepository

class NumberUseCase(private val numberRepository: NumberRepository) {

    operator fun invoke() = numberRepository.getNumbers()
}