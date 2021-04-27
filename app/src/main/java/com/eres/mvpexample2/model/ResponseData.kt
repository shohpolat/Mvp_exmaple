package com.eres.kutubxonasample.model

import com.google.gson.annotations.SerializedName

data class ResponseData(

    @field:SerializedName("date")
    val singleDate: SingleDate? = null
)
