package com.eres.kutubxonasample.model

import com.eres.mvpexample2.model.Timings
import com.google.gson.annotations.SerializedName

data class ResponseData2(

    @field:SerializedName("timings")
    val times: Timings? = null,

    @field:SerializedName("meta")
    val meta: Meta? = null
) {
    data class Meta(
        @field:SerializedName("method")
        val method: Method? = null
    ) {
        data class Method(
            @field:SerializedName("id")
            val id: String? = null,

            @field:SerializedName("name")
            val name: String? = null
        )
    }


}
