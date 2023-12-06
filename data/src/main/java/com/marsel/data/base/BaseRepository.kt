package com.marsel.data.base

import com.marse.domain.tools.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

abstract class BaseRepository {

    fun <T> doRequest(result: suspend () -> T) = flow {
        try {
            val data = withContext(Dispatchers.IO) {
                result() // Выполняем операцию в IO-потоке
            }
            emit(Either.Right(data))
        } catch (ioException: IllegalStateException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }
}