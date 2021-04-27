package com.eres.kutubxonasample.model

import com.google.gson.annotations.SerializedName

data class SingleDate(

    @field:SerializedName("readable")
    val date: String? = null,

    @field:SerializedName("timestamp")
    val timestamp: String? = null

)
