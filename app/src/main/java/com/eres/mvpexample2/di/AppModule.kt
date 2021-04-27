package com.eres.mvpexample2.di

import com.eres.mvpexample2.API.api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {



    @Provides
    @Singleton
    fun provideRxCallAdapter() = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideGsonConverter() = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder().baseUrl(api.base_url)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): api = retrofit.create(api::class.java)

}