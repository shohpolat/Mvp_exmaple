package com.eres.kutubxonasample.model

import com.eres.mvpexample2.model.BaseModelClass
import com.google.gson.annotations.SerializedName

data class SampleResponse<T>(
    @field:SerializedName("data")
    val data: List<T>? = null
) : BaseModelClass()