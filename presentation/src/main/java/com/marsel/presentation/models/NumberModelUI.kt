package com.marsel.presentation.models

import com.marse.domain.models.NumberModel
import com.marsel.presentation.tools.diffUtil.BaseDiffModel

data class NumberModelUI(
    override val id: Int,
    val name: String,
    val price: Int,
    val pricePer: String,
    val peculiarities: List<String>,
    val images: List<String>
) : BaseDiffModel<Int>

fun NumberModel.toUI() = NumberModelUI(
    id = id,
    name = name,
    price = price,
    pricePer = pricePer,
    peculiarities = peculiarities,
    images = images
)
