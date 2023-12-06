package com.marse.domain.repositories

import com.marse.domain.models.NumberModel
import com.marse.domain.tools.Either
import kotlinx.coroutines.flow.Flow

interface NumberRepository {

    fun getNumbers(): Flow<Either<String, List<NumberModel>>>
}