package io.quarter.coreui

import android.os.Parcelable
import androidx.compose.Composable

/*
 * Author: steelahhh
 * 12/5/20
 */

abstract class ComposeKey : Parcelable {
  @Composable
  abstract fun content()
}
