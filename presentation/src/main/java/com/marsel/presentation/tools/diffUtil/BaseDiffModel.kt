package com.marsel.presentation.tools.diffUtil

interface BaseDiffModel<T> {
    val id: T?
    override fun equals(other: Any?): Boolean
}
