package com.oliferov.test_for_reshenie_soft.presentation.screen

import android.app.Application
import com.oliferov.test_for_reshenie_soft.di.DaggerApplicationComponent

class UserPostsApp : Application(){
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}