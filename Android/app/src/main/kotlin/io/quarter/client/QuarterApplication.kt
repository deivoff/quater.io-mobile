package io.quarter.client

import android.app.Application
import io.quarter.data.DataModule
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
    setupDi()
  }

  private fun setupDi() {
    DataModule.init(this)
  }

  private fun setupTimber() {
    if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
  }
}
