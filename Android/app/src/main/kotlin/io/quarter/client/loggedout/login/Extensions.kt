package io.quarter.client.loggedout.login

import io.quarter.data.authorization.AuthorizationInput

val AuthorizationInput.isEmpty: Boolean get() = login.isEmpty() || password.isEmpty()
