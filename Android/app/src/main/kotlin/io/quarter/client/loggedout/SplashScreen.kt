package io.quarter.client.loggedout

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.Spacer
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.height
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.text.style.TextAlign
import androidx.ui.unit.dp
import io.quarter.client.BackstackAmbient
import io.quarter.client.loggedout.login.LoginKey
import io.quarter.client.loggedout.register.RegisterKey
import io.quarter.core.Strings
import io.quarter.coreui.composables.PrimaryButton

/*
 * Author: steelahhh
 * 12/5/20
 */

@Composable
fun SplashScreen() {
  val backstack = BackstackAmbient.current

  Column(
    modifier = Modifier.padding(16.dp).fillMaxSize(),
    verticalArrangement = Arrangement.Center
  ) {
    Text(
      modifier = Modifier.fillMaxWidth(),
      text = Strings.brand,
      style = MaterialTheme.typography.h2.copy(
        textAlign = TextAlign.Center
      )
    )
    Spacer(modifier = Modifier.height(height = 92.dp))
    PrimaryButton(
      text = Strings.Authorization.login,
      onClick = { backstack.goTo(LoginKey()) }
    )
    Spacer(modifier = Modifier.height(height = 16.dp))
    PrimaryButton(
      text = Strings.Authorization.register,
      onClick = { backstack.goTo(RegisterKey()) }
    )
  }
}
