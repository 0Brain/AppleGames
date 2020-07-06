package com.prasan.applegames.initializer

import android.content.Context
import androidx.multidex.BuildConfig
import androidx.startup.Initializer
import timber.log.Timber

class TimberInitializer:Initializer<Unit> {
    override fun create(context: Context) {
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        Timber.d("Timber has been initialized")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}