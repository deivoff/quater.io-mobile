package io.quarter.client.loggedin

import android.os.Parcel
import android.os.Parcelable
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.Spacer
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.text.style.TextAlign
import androidx.ui.unit.dp
import com.zhuinden.simplestack.StateChange
import io.quarter.client.BackstackAmbient
import io.quarter.client.DependencyContextAmbient
import io.quarter.client.loggedout.SplashKey
import io.quarter.coreui.ComposeKey
import io.quarter.coreui.composables.PrimaryButton

data class LoggedInRootKey(private val placeholder: String = "") : ComposeKey() {
  constructor(parcel: Parcel) : this(parcel.readString()!!)

  @Composable
  override fun content() {
    val loginViewModel = DependencyContextAmbient.current.loginViewModel
    val backstack = BackstackAmbient.current

    Column(
      modifier = Modifier.fillMaxHeight().padding(16.dp)
    ) {
      Text(
        text = "Authorized", style = MaterialTheme.typography.h3.copy(
          textAlign = TextAlign.Center
        )
      )
      Spacer(modifier = Modifier.weight(weight = 1f))
      PrimaryButton(
        text = "Выйти",
        onClick = {
          loginViewModel.logout()
          backstack.replaceTop(SplashKey(), StateChange.REPLACE)
        }
      )
    }
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(placeholder)
  }

  override fun describeContents(): Int = 0

  companion object CREATOR : Parcelable.Creator<LoggedInRootKey> {
    override fun createFromParcel(parcel: Parcel): LoggedInRootKey {
      return LoggedInRootKey(parcel)
    }

    override fun newArray(size: Int): Array<LoggedInRootKey?> {
      return arrayOfNulls(size)
    }
  }
}
