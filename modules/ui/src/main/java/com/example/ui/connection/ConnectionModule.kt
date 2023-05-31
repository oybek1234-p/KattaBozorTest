package com.example.ui.connection

import android.app.Activity
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
class ConnectionModule(private val activity: Activity) {

    @Provides
    fun provideConnectionObserver() = ConnectionObserver(activity = activity)
}