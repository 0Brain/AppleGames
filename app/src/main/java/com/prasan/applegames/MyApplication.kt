package com.prasan.applegames

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {
    private lateinit var context:Context

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
        context = applicationContext
    }

    fun getContext():Context{
        return context
    }
}