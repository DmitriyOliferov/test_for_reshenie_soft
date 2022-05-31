package com.oliferov.test_for_reshenie_soft.di

import android.app.Application
import com.oliferov.test_for_reshenie_soft.data.database.AppDatabase
import com.oliferov.test_for_reshenie_soft.data.database.UserPostsDao
import com.oliferov.test_for_reshenie_soft.data.mapper.NewsMapper
import com.oliferov.test_for_reshenie_soft.data.mapper.UserMapper
import com.oliferov.test_for_reshenie_soft.data.network.ApiFactory
import com.oliferov.test_for_reshenie_soft.data.network.ApiService
import com.oliferov.test_for_reshenie_soft.data.repository.UserPostsRepositoryImpl
import com.oliferov.test_for_reshenie_soft.domain.UserPostsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindUserPostsRepository(impl: UserPostsRepositoryImpl): UserPostsRepository

    companion object {

        @Provides
        fun provideUserPostsDao(application: Application): UserPostsDao {
            return AppDatabase.getInstance(application).userPostsDao()
        }

        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @Provides
        fun provideNewsMapper(): NewsMapper {
            return NewsMapper()
        }

        @Provides
        fun provideUserMapper(): UserMapper {
            return UserMapper()
        }
    }
}