package com.marsel.data.remote.dtos

import com.google.gson.annotations.SerializedName
import com.marse.domain.models.NumberModel

data class NumberDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("price_per")
    val pricePer: String,
    @SerializedName("peculiarities")
    val peculiarities: List<String>,
    @SerializedName("image_urls")
    val images: List<String>
)

fun NumberDto.toDomain() = NumberModel(
    id = id,
    name = name,
    price = price,
    pricePer = pricePer,
    peculiarities = peculiarities,
    images = images
)