package com.eres.mvpexample2.dataState

import java.lang.Exception

sealed class DataState<out T> {
    data class Success<out R>(val data: R) : DataState<R>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    data class Throwable(val exception: kotlin.Throwable) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
    object Complete : DataState<Nothing>()
}
