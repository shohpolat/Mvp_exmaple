package com.eres.mvpexample2.ui.second

import com.eres.kutubxonasample.Repository.RepositoryImpl
import com.eres.mvpexample2.base.BasePresenter
import com.eres.mvpexample2.dataState.DataState
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class SecondPresenter : BasePresenter<SecondView>() {

    @Inject
    lateinit var repository: RepositoryImpl

    private lateinit var owner: SecondFragment

    fun setOwner(secondFragment: SecondFragment) {
        this.owner = secondFragment
    }

    fun getSearchedText(month: Int, year: Int, method: Int) {

        val dataState = repository.getBooks(
            month = month,
            year = year,
            method = method
        )

        dataState.observe(owner, androidx.lifecycle.Observer {

            when (it) {
                is DataState.Success -> {

                    viewState.hideProgressBar()
                    viewState.showBooks(it.data)

                }
                is DataState.Error -> {

                    viewState.hideProgressBar()
                    viewState.showNotFoundUI()

                }
                is DataState.Loading -> {

                    viewState.showProgressBar()

                }
                else -> {
                }
            }
        })
    }

//        presenterScope.launch {
//            repository.getBooks(
//                month = month,
//                year = year,
//                method = method
//            ).collect { dataState ->
//                when (dataState) {
//                    is DataState.Success -> {
//
//                        viewState.hideProgressBar()
//                        viewState.showBooks(dataState.data)
//
//                    }
//                    is DataState.Error -> {
//
//                        viewState.hideProgressBar()
//                        viewState.showNotFoundUI()
//
//                    }
//                    is DataState.Loading -> {
//
//                        viewState.showProgressBar()
//
//                    }
//                }
//
//            }
//
//        }

}