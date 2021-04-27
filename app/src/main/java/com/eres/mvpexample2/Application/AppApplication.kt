package com.eres.mvpexample2.Application

import android.app.Application
import com.eres.mvpexample2.di.AppComponent
import com.eres.mvpexample2.di.DaggerAppComponent

class AppApplication:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create()

    }

}