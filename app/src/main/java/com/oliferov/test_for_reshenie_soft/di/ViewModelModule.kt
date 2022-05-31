package com.oliferov.test_for_reshenie_soft.di

import androidx.lifecycle.ViewModel
import com.oliferov.test_for_reshenie_soft.presentation.screen.listnews.NewsListViewModel
import com.oliferov.test_for_reshenie_soft.presentation.screen.listuser.UsersListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UsersListViewModel::class)
    fun bindUserListViewModel(viewModel: UsersListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel::class)
    fun bindNewsListViewModel(viewModel: NewsListViewModel): ViewModel
}