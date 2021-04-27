package com.eres.mvpexample2.base

import moxy.MvpPresenter

abstract class BasePresenter<T : BaseView> : MvpPresenter<T>() {
}