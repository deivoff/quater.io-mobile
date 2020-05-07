package io.quarter.client.loggedout.register

import io.quarter.data.register.RegisterInput

fun RegisterInput.isEmpty() =
  email.isEmpty() || password.isEmpty() || lastName.isEmpty() || firstName.isEmpty()
