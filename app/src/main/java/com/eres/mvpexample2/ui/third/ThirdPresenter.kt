package com.eres.mvpexample2.ui.third

import com.eres.kutubxonasample.Repository.Repository
import com.eres.kutubxonasample.Repository.RepositoryImpl
import com.eres.kutubxonasample.model.SampleResponse2
import com.eres.mvpexample2.base.BasePresenter
import com.eres.mvpexample2.dataState.DataState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.presenterScope
import javax.inject.Inject

@InjectViewState
class ThirdPresenter : BasePresenter<ThirdView>() {


    @Inject
    lateinit var repository: RepositoryImpl

    fun getTimings(timestamp: String,method:Int) {

        presenterScope.launch {

            repository.getTimings(timestamp,method).collect { dataState ->

                when (dataState) {
                    is DataState.Success -> {

                        viewState.hideProgressBar()
                        viewState.showPrayerTimes(dataState.data.data!!)

                    }
                    is DataState.Error -> {

                        viewState.hideProgressBar()
                        viewState.showNotFoundUI()

                    }
                    is DataState.Loading -> {

                        viewState.showProgressBar()

                    }
                }

            }

        }

    }


}