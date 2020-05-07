package io.quarter.client.loggedout.login

import androidx.compose.Model
import androidx.ui.foundation.TextFieldValue

/*
 * Author: steelahhh
 * 9/5/20
 */

@Model
data class LoginInput(
  var login: TextFieldValue = TextFieldValue(),
  var password: TextFieldValue = TextFieldValue()
)
