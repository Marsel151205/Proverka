package com.marsel.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class NumberResponse(
    @SerializedName("rooms")
    val rooms: List<NumberDto>
)
