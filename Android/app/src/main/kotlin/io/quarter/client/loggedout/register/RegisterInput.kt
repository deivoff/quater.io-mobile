package io.quarter.client.loggedout.register

import androidx.compose.Model
import androidx.ui.foundation.TextFieldValue

/*
 * Author: steelahhh
 * 9/5/20
 */

@Model
data class RegisterInput(
  var email: TextFieldValue = TextFieldValue(),
  var password: TextFieldValue = TextFieldValue(),
  var lastName: TextFieldValue = TextFieldValue(),
  var firstName: TextFieldValue = TextFieldValue(),
  var patronymic: TextFieldValue = TextFieldValue()
)
