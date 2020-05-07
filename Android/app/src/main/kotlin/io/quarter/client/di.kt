package io.quarter.client

import androidx.compose.ProvidableAmbient
import androidx.compose.ambientOf
import io.quarter.client.loggedout.login.LoginViewModel
import io.quarter.client.loggedout.register.RegisterViewModel
import io.quarter.client.root.RootViewModel

/*
 * Author: steelahhh
 * 7/5/20
 */

interface DependencyContext {
  val loginViewModel: LoginViewModel
  val registerViewModel: RegisterViewModel
  val rootViewModel: RootViewModel
}

val DependencyContextAmbient: ProvidableAmbient<DependencyContext> = ambientOf {
  throw Throwable("Dependency Context is not initialized")
}
