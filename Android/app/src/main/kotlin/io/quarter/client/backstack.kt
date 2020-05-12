package io.quarter.client

import androidx.compose.Model
import androidx.compose.ProvidableAmbient
import androidx.compose.ambientOf
import com.zhuinden.simplestack.Backstack
import io.quarter.coreui.ComposeKey

/*
 * Author: steelahhh
 * 12/5/20
 */

val BackstackAmbient: ProvidableAmbient<Backstack> = ambientOf {
  throw RuntimeException("Initialize Backstack ambient in the host activity")
}

@Model
class BackstackState(var screens: List<ComposeKey>)
