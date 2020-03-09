package io.quarter.client

import android.app.Application
import io.quarter.client.loggedout.loggedOutModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.koin.viewModel
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent
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
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@QuarterApplication)
            modules(loggedOutModule)
        }
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
