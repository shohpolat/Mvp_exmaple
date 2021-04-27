package com.eres.kutubxonasample.Repository

import com.eres.kutubxonasample.model.*
import com.eres.mvpexample2.API.api
import com.eres.mvpexample2.dataState.DataState
import com.eres.mvpexample2.model.Timings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class RepositoryImpl
@Inject
constructor(private val api: api) : Repository {

    override suspend fun getBooks(
        month: Int,
        year: Int,
        method: Int
    ): Flow<DataState<SampleResponse<ResponseData>>> = flow {

        emit(DataState.Loading)

        try {
            println("sending request...")
            val data = api.getForMonth(
                lat = constants.latitude,
                long = constants.longitude,
                month = month,
                year = year,
                method = method
            )

            println(data.code)
            println(data.status)

            emit(DataState.Success(data))

        } catch (e: Exception) {
            println("error = ${e.message}")
            emit(DataState.Error(e))
        }

    }

    override suspend fun getTimings(
        timestamp: String,
        method: Int
    ): Flow<DataState<SampleResponse2<ResponseData2>>> =
        flow {

            emit(DataState.Loading)

            try {

                val timings = api.getForSingleDate(
                    timestamp = timestamp,
                    lat = constants.latitude,
                    long = constants.longitude,
                    method = method
                )

                println(timings.code)
                println(timings.status)

                emit(DataState.Success(timings))

            } catch (e: Exception) {
                println("error = ${e.message}")
                emit(DataState.Error(e))
            }

        }
}

