package com.eres.kutubxonasample.Repository

import com.eres.kutubxonasample.model.ResponseData
import com.eres.kutubxonasample.model.ResponseData2
import com.eres.kutubxonasample.model.SampleResponse
import com.eres.kutubxonasample.model.SampleResponse2
import com.eres.mvpexample2.dataState.DataState
import com.eres.mvpexample2.model.Timings
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getBooks(month: Int, year: Int, method:Int): Flow<DataState<SampleResponse<ResponseData>>>

    suspend fun getTimings(timestamp: String,method: Int): Flow<DataState<SampleResponse2<ResponseData2>>>
}