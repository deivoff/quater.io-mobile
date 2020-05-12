package io.quarter.client.loggedout.login

import android.os.Parcel
import android.os.Parcelable
import androidx.compose.Composable
import io.quarter.coreui.ComposeKey

data class LoginKey(private val placeholder: String = "") : ComposeKey() {
  constructor(parcel: Parcel) : this(parcel.readString()!!)

  @Composable
  override fun content() {
    LoginScreen()
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(placeholder)
  }

  override fun describeContents(): Int = 0

  companion object CREATOR : Parcelable.Creator<LoginKey> {
    override fun createFromParcel(parcel: Parcel): LoginKey {
      return LoginKey(parcel)
    }

    override fun newArray(size: Int): Array<LoginKey?> {
      return arrayOfNulls(size)
    }
  }
}
