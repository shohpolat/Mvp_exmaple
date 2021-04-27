package com.eres.mvpexample2.model

import com.google.gson.annotations.SerializedName

data class Timings(
    @field:SerializedName("Fajr")
    var bomdot: String? = null,

    @field:SerializedName("Sunrise")
    var quyosh: String? = null,

    @field:SerializedName("Dhuhr")
    var peshin: String? = null,

    @field:SerializedName("Asr")
    var asr: String? = null,

    @field:SerializedName("Sunset")
    var quyosh_botishi: String? = null,

    @field:SerializedName("Maghrib")
    var shom: String? = null,

    @field:SerializedName("Isha")
    var xufton: String? = null,

    @field:SerializedName("Imsak")
    var imsak: String? = null,

    @field:SerializedName("Midnight")
    var tun_yarmi: String? = null
)
