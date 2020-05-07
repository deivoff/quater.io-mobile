package io.quarter.data.register

/*
 * Author: steelahhh
 * 9/3/20
 */

data class RegisterInput(
  val email: String = "",
  val password: String = "",
  val lastName: String = "",
  val firstName: String = "",
  val patronymic: String = ""
)
