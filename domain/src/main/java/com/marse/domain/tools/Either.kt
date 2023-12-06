package com.marse.domain.tools

sealed class Either<out L, out R> {
    data class Left<out L>(val message: L) : Either<L, Nothing>()
    data class Right<out R>(val data: R) : Either<Nothing, R>()
}