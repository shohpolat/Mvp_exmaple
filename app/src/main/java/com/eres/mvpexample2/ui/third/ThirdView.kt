package com.eres.mvpexample2.ui.third

import com.eres.kutubxonasample.model.ResponseData
import com.eres.kutubxonasample.model.ResponseData2
import com.eres.kutubxonasample.model.SampleResponse
import com.eres.mvpexample2.base.BaseView
import com.eres.mvpexample2.model.Timings
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ThirdView : BaseView {

    @AddToEndSingle
    fun showPrayerTimes(responseData2: ResponseData2)

    @AddToEndSingle
    fun showNotFoundUI()

    @AddToEndSingle
    fun showProgressBar()

    @AddToEndSingle
    fun hideProgressBar()

}