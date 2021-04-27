package com.eres.mvpexample2.di

import com.eres.mvpexample2.ui.second.SecondFragment
import com.eres.mvpexample2.ui.second.SecondPresenter
import com.eres.mvpexample2.ui.third.ThirdFragment
import com.eres.mvpexample2.ui.third.ThirdPresenter
import dagger.Subcomponent


@ActivityScope
@Subcomponent
interface ActivityComponent {

    fun inject(secondFragment: SecondFragment)

    fun inject(secondPresenter: SecondPresenter)

    fun inject(thirdFragment: ThirdFragment)
    fun inject(thirdPresenter: ThirdPresenter)


    @Subcomponent.Factory
    interface Factory {
        fun create(
        ): ActivityComponent
    }

}