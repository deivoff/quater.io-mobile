package io.quarter.client.loggedout

import android.os.Parcel
import android.os.Parcelable
import androidx.compose.Composable
import io.quarter.coreui.ComposeKey

/*
 * Author: steelahhh
 * 12/5/20
 */

data class SplashKey(private val placeholder: String = "") : ComposeKey() {
  constructor(parcel: Parcel) : this(parcel.readString()!!)

  @Composable
  override fun content() {
    SplashScreen()
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(placeholder)
  }

  override fun describeContents(): Int = 0

  companion object CREATOR : Parcelable.Creator<SplashKey> {
    override fun createFromParcel(parcel: Parcel): SplashKey {
      return SplashKey(parcel)
    }

    override fun newArray(size: Int): Array<SplashKey?> {
      return arrayOfNulls(size)
    }
  }
}
