package com.marsel.data.repositories

import com.marse.domain.models.NumberModel
import com.marse.domain.repositories.NumberRepository
import com.marse.domain.tools.Either
import com.marsel.data.base.BaseRepository
import com.marsel.data.remote.dtos.toDomain
import com.marsel.data.services.NumberApiService
import kotlinx.coroutines.flow.Flow

class NumberRepositoryImpl(private val numberApiService: NumberApiService) : NumberRepository,
    BaseRepository() {

    override fun getNumbers(): Flow<Either<String, List<NumberModel>>> = doRequest {
        numberApiService.fetchNumbers().rooms.map { it.toDomain() }
    }
}