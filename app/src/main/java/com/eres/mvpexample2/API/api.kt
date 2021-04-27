package com.eres.mvpexample2.API

import com.eres.kutubxonasample.model.ResponseData
import com.eres.kutubxonasample.model.ResponseData2
import com.eres.kutubxonasample.model.SampleResponse
import com.eres.kutubxonasample.model.SampleResponse2
import com.eres.mvpexample2.model.Timings
import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface api {

    companion object {
        const val base_url = "http://api.aladhan.com/v1/"
    }

    //    @GET("calendar")
//    suspend fun getForMonth(
//        @Query("latitude") lat: Double,
//        @Query("longitude") long: Double,
//        @Query("month") month: Int,
//        @Query("year") year: Int,
//        @Query("method") method: Int,
//    ): SampleResponse<ResponseData>
//
    @GET("timings/{timestamp}")
    suspend fun getForSingleDate(
        @Path("timestamp") timestamp: String,
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
        @Query("method") method: Int,
    ): SampleResponse2<ResponseData2>

    @GET("calendar")
    fun getForMonth(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
        @Query("month") month: Int,
        @Query("year") year: Int,
        @Query("method") method: Int,
    ): Flowable<SampleResponse<ResponseData>>

//    @GET("timings/{timestamp}")
//    suspend fun getForSingleDate(
//        @Path("timestamp") timestamp: String,
//        @Query("latitude") lat: Double,
//        @Query("longitude") long: Double,
//        @Query("method") method: Int,
//    ): ResponseData2


}