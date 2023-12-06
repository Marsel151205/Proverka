package com.marse.domain.models

data class NumberModel(
    val id: Int,
    val name: String,
    val price: Int,
    val pricePer: String,
    val peculiarities: List<String>,
    val images: List<String>
)
