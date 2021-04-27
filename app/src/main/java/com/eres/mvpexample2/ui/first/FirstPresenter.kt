package com.eres.mvpexample2.ui.first

import com.eres.mvpexample2.base.BasePresenter
import moxy.InjectViewState

@InjectViewState
class FirstPresenter : BasePresenter<FirstView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showToast("This is some toast message!")
    }

    fun showToastAgain() {

        viewState.showToast("This is second toast!")

    }

}
