package io.quarter.client

import android.app.Application
import timber.log.Timber

/*
 * Author: steelahhh
 * 17/11/19
 */

@Suppress("unused")
class QuarterApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
