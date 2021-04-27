package com.eres.kutubxonasample.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eres.kutubxonasample.model.*
import com.eres.mvpexample2.API.api
import com.eres.mvpexample2.dataState.DataState
import com.eres.mvpexample2.model.Timings
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class RepositoryImpl
@Inject
constructor(private val api: api) : Repository {

    val TAG = "ttt"

//    override suspend fun getBooks(
//        month: Int,
//        year: Int,
//        method: Int
//    ): DataState<SampleResponse<ResponseData>> {
//        try {
//            println("sending request...")
//            val data = api.getForMonth(
//                lat = constants.latitude,
//                long = constants.longitude,
//                month = month,
//                year = year,
//                method = method
//            ).toObservable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object : Observer<ResponseData> {
//                    override fun onSubscribe(d: Disposable) {
//                        Log.d(TAG, "onSubscribe: ")
//                        DataState.Loading
//                    }
//
//                    override fun onNext(t: ResponseData) {
//                        DataState.Success(t)
//                    }
//
//                    override fun onError(e: Throwable) {
//
//                    }
//
//                    override fun onComplete() {
//                        DataState.Complete
//                    }
//                })
//
//        } catch (e: Exception) {
//            println("error = ${e.message}")
//            return (DataState.Error(e))
//        }
//
//    }

    override fun getBooks(
        month: Int,
        year: Int,
        method: Int
    ): LiveData<DataState<SampleResponse<ResponseData>>> {
        println("sending request...")

        val sampleResponse = MutableLiveData<DataState<SampleResponse<ResponseData>>>()

        api.getForMonth(
            lat = constants.latitude,
            long = constants.longitude,
            month = month,
            year = year,
            method = method
        ).toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : Observer<SampleResponse<ResponseData>> {
                    override fun onSubscribe(d: Disposable) {
                        sampleResponse.value = DataState.Loading
                    }

                    override fun onNext(t: SampleResponse<ResponseData>) {
                        sampleResponse.value = DataState.Success(t)
                    }

                    override fun onError(e: Throwable) {
                        sampleResponse.value = DataState.Throwable(e)
                    }

                    override fun onComplete() {
                        sampleResponse.value = DataState.Complete
                    }
                })

        return sampleResponse

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

