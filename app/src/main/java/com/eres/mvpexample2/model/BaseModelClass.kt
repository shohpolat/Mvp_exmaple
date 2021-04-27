package com.eres.mvpexample2.model

import com.google.gson.annotations.SerializedName

abstract class BaseModelClass(

    @field:SerializedName("code")
    var code: Int? = null,

    @field:SerializedName("status")
    var status: String? = null
)