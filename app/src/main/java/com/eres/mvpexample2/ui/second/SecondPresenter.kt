package com.eres.mvpexample2.ui.second

import com.eres.kutubxonasample.Repository.RepositoryImpl
import com.eres.mvpexample2.base.BasePresenter
import com.eres.mvpexample2.dataState.DataState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.presenterScope
import javax.inject.Inject

@InjectViewState
class SecondPresenter : BasePresenter<SecondView>() {

    @Inject
    lateinit var repository: RepositoryImpl

    fun getSearchedText(month: Int, year: Int, method: Int) {

        presenterScope.launch {
            repository.getBooks(
                month = month,
                year = year,
                method = method
            ).collect { dataState ->
                when (dataState) {
                    is DataState.Success -> {

                        viewState.hideProgressBar()
                        viewState.showBooks(dataState.data)

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