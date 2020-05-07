package io.quarter.client.loggedout.register

import android.app.Activity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.ContextAmbient
import androidx.ui.core.FocusManagerAmbient
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import androidx.ui.text.AnnotatedString
import androidx.ui.text.SpanStyle
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextDecoration
import androidx.ui.unit.dp
import io.quarter.core.Strings
import io.quarter.coreui.composables.LoaderButton
import io.quarter.coreui.composables.PasswordTextInput
import io.quarter.coreui.composables.TextInput
import io.quarter.coreui.extensions.hideKeyboard
import io.quarter.coreui.extensions.modify
import io.quarter.coreui.observe
import io.quarter.data.register.RegisterInput

interface Register {
  companion object {
    @Composable
    fun Content(
      viewModel: RegisterViewModel,
      onBackClick: () -> Unit,
      onLoginClick: () -> Unit,
      onLoggedIn: () -> Unit
    ) {
      val registerViewState = observe(viewModel.registerViewState)

      if (registerViewState?.isRegisterSuccess == true) onLoggedIn()

      Column(
        modifier = LayoutWidth.Fill + LayoutHeight.Fill
      ) {
        val focusManager = FocusManagerAmbient.current
        val context = ContextAmbient.current
        val registerInput = state { RegisterInput() }

        TopAppBar(
          title = { Text(text = Strings.Authorization.registerTitle) },
          color = Color.White,
          elevation = 4.dp,
          navigationIcon = {
            IconButton(onClick = onBackClick) {
              Icon(icon = Icons.Default.ArrowBack)
            }
          }
        )
        VerticalScroller {
          Column(modifier = LayoutPadding(16.dp)) {
            TextInput(
              identifier = "EmailId",
              hint = Strings.Register.email,
              value = registerInput.value.email,
              error = Strings.Register.emailError.takeIf {
                registerViewState?.isEmailInvalid == true
              },
              onImeAction = { focusManager.requestFocusById("PasswordId") }
            ) {
              registerInput.modify { copy(email = it) }
            }
            PasswordTextInput(
              identifier = "PasswordId",
              hint = Strings.Authorization.password,
              value = registerInput.value.password,
              onImeAction = { focusManager.requestFocusById("LastNameId") }
            ) {
              registerInput.modify { copy(password = it) }
            }
            TextInput(
              identifier = "LastNameId",
              hint = Strings.Register.lastName,
              value = registerInput.value.lastName,
              onImeAction = { focusManager.requestFocusById("FirstNameId") }
            ) {
              registerInput.modify { copy(lastName = it) }
            }
            TextInput(
              identifier = "FirstNameId",
              hint = Strings.Register.firstName,
              value = registerInput.value.firstName,
              onImeAction = { focusManager.requestFocusById("PatronymicId") }
            ) {
              registerInput.modify { copy(firstName = it) }
            }
            TextInput(
              identifier = "PatronymicId",
              hint = Strings.Register.patronymic,
              value = registerInput.value.patronymic,
              imeAction = ImeAction.Done,
              onImeAction = { action ->
                if (action == ImeAction.Done) hideKeyboard(context as Activity)
              }
            ) {
              registerInput.modify { copy(patronymic = it) }
            }
            LoaderButton(
              text = Strings.Authorization.register,
              isLoading = registerViewState?.isLoading == true,
              isEnabled = !registerInput.value.isEmpty(),
              onClick = {
                hideKeyboard(context as Activity)
                viewModel.register(registerInput.value)
              }
            )
            if (registerViewState?.isError == true) {
              Column(modifier = LayoutPadding(4.dp)) {
                Text(
                  text = Strings.Register.registerError,
                  style = MaterialTheme.typography().subtitle2.copy(
                    color = MaterialTheme.colors().error
                  )
                )
              }
            }
            Spacer(modifier = LayoutHeight.Min(8.dp))
            Row(
              modifier = LayoutWidth.Fill,
              arrangement = Arrangement.Center
            ) {
              Text(
                text = "${Strings.Register.alreadyClient} ",
                style = TextStyle(color = Color.Black.copy(alpha = 0.5f))
              )
              Clickable(onClick = onLoginClick) {
                val loginText = AnnotatedString(
                  text = Strings.Authorization.login,
                  spanStyle = SpanStyle(
                    color = Color.Black,
                    textDecoration = TextDecoration.Underline
                  )
                )
                Text(text = loginText)
              }
            }
          }
        }
      }
    }
  }
}
