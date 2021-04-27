package com.eres.mvpexample2.ui.first

import com.eres.mvpexample2.base.BaseView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface FirstView : BaseView {

    @AddToEndSingle
    fun showToast(toastMessage: String)
}