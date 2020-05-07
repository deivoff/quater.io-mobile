package io.quarter.client.loggedout.login

import io.quarter.data.authorization.AuthorizationData

val LoginInput.asData get() = AuthorizationData(login.text, password.text)

val LoginInput.isEmpty: Boolean get() = login.text.isEmpty() || password.text.isEmpty()
