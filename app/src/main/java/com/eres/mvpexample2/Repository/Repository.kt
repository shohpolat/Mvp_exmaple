package com.eres.kutubxonasample.Repository

import androidx.lifecycle.LiveData
import com.eres.kutubxonasample.model.ResponseData
import com.eres.kutubxonasample.model.ResponseData2
import com.eres.kutubxonasample.model.SampleResponse
import com.eres.kutubxonasample.model.SampleResponse2
import com.eres.mvpexample2.dataState.DataState
import com.eres.mvpexample2.model.Timings
import io.reactivex.Flowable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getBooks(month: Int, year: Int, method: Int): LiveData<DataState<SampleResponse<ResponseData>>>?

    suspend fun getTimings(
        timestamp: String,
        method: Int
    ): Flow<DataState<SampleResponse2<ResponseData2>>>
}