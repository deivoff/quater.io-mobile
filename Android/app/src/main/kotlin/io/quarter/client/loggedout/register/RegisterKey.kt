package io.quarter.client.loggedout.register

import android.os.Parcel
import android.os.Parcelable
import androidx.compose.Composable
import io.quarter.coreui.ComposeKey

/*
 * Author: steelahhh
 * 12/5/20
 */

data class RegisterKey(private val placeholder: String = "") : ComposeKey() {
  constructor(parcel: Parcel) : this(parcel.readString()!!)

  @Composable
  override fun content() {
    RegisterScreen()
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(placeholder)
  }

  override fun describeContents(): Int = 0

  companion object CREATOR : Parcelable.Creator<RegisterKey> {
    override fun createFromParcel(parcel: Parcel): RegisterKey {
      return RegisterKey(parcel)
    }

    override fun newArray(size: Int): Array<RegisterKey?> {
      return arrayOfNulls(size)
    }
  }
}
