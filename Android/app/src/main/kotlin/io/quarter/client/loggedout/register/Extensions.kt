package io.quarter.client.loggedout.register

import io.quarter.data.register.RegisterData

val RegisterInput.asData get() = RegisterData(
  email = email.text,
  password = password.text,
  lastName = lastName.text,
  firstName = firstName.text,
  patronymic = patronymic.text
)

fun RegisterInput.isEmpty() =
  email.text.isEmpty() ||
      password.text.isEmpty() ||
      lastName.text.isEmpty() ||
      firstName.text.isEmpty()
