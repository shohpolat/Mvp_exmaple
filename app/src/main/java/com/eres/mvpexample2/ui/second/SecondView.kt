package com.eres.mvpexample2.ui.second

import com.eres.kutubxonasample.model.ResponseData
import com.eres.kutubxonasample.model.SampleResponse
import com.eres.mvpexample2.base.BaseView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface SecondView : BaseView {

    @AddToEndSingle
    fun showBooks(data: SampleResponse<ResponseData>)

    @AddToEndSingle
    fun showNotFoundUI()

    @AddToEndSingle
    fun showProgressBar()

    @AddToEndSingle
    fun hideProgressBar()


}