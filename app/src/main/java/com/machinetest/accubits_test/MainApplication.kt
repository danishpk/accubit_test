package com.machinetest.accubits_test

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import java.lang.Boolean

@HiltAndroidApp
class MainApplication : Application() {

    val DEBUG = Boolean.parseBoolean("true")

    override fun onCreate() {
        super.onCreate()
        if (DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}