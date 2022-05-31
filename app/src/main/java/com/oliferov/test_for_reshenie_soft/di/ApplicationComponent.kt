package com.oliferov.test_for_reshenie_soft.di

import android.app.Application
import com.oliferov.test_for_reshenie_soft.presentation.screen.UserPostsApp
import com.oliferov.test_for_reshenie_soft.presentation.screen.listnews.NewsListFragment
import com.oliferov.test_for_reshenie_soft.presentation.screen.listuser.UsersListFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

    fun inject(fragment: UsersListFragment)

    fun inject(fragment: NewsListFragment)

    fun inject(application: UserPostsApp)
}