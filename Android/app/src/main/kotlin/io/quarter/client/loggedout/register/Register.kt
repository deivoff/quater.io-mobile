package io.quarter.client.loggedout.register

import android.app.Activity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.state
import androidx.ui.core.ContextAmbient
import androidx.ui.core.FocusManagerAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.TextFieldValue
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.layout.preferredHeightIn
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
import io.quarter.client.DependencyContextAmbient
import io.quarter.core.Strings
import io.quarter.coreui.composables.LoaderButton
import io.quarter.coreui.composables.PasswordTextInput
import io.quarter.coreui.composables.TextInput
import io.quarter.coreui.extensions.hideKeyboard
import io.quarter.coreui.observe

interface Register {
  companion object {
    @Composable
    fun Content(
      onBackClick: () -> Unit,
      onLoginClick: () -> Unit,
      onLoggedIn: () -> Unit
    ) {
      val viewModel = DependencyContextAmbient.current.registerViewModel
      val focusManager = FocusManagerAmbient.current
      val context = ContextAmbient.current
      val registerInput = state { RegisterInput() }

      val registerViewState = observe(viewModel.registerViewState)
      if (registerViewState?.isRegisterSuccess == true) onLoggedIn()

      Column(
        modifier = Modifier.fillMaxSize()
      ) {

        TopAppBar(
          title = { Text(text = Strings.Authorization.registerTitle) },
          backgroundColor = Color.White,
          elevation = 4.dp,
          navigationIcon = {
            IconButton(onClick = onBackClick) {
              Icon(asset = Icons.Default.ArrowBack)
            }
          }
        )
        VerticalScroller {
          Column(modifier = Modifier.padding(16.dp)) {
            TextInput(
              identifier = "EmailId",
              hint = Strings.Register.email,
              value = registerInput.value.email,
              error = Strings.Register.emailError.takeIf {
                registerViewState?.isEmailInvalid == true
              },
              onImeAction = { focusManager.requestFocusById("PasswordId") }
            ) {
              registerInput.value.email = it
            }
            PasswordTextInput(
              identifier = "PasswordId",
              hint = Strings.Authorization.password,
              value = registerInput.value.password,
              onImeAction = { focusManager.requestFocusById("LastNameId") }
            ) {
              registerInput.value.password = it
            }
            TextInput(
              identifier = "LastNameId",
              hint = Strings.Register.lastName,
              value = registerInput.value.lastName,
              onImeAction = { focusManager.requestFocusById("FirstNameId") }
            ) {
              registerInput.value.lastName = it
            }
            TextInput(
              identifier = "FirstNameId",
              hint = Strings.Register.firstName,
              value = registerInput.value.firstName,
              onImeAction = { focusManager.requestFocusById("PatronymicId") }
            ) {
              registerInput.value.firstName = it
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
              registerInput.value.patronymic = it
            }
            LoaderButton(
              text = Strings.Authorization.register,
              isLoading = registerViewState?.isLoading == true,
              isEnabled = !registerInput.value.isEmpty(),
              onClick = {
                hideKeyboard(context as Activity)
                viewModel.register(registerInput.value.asData)
              }
            )
            if (registerViewState?.isError == true) {
              Column(modifier = Modifier.padding(4.dp)) {
                Text(
                  text = Strings.Register.registerError,
                  style = MaterialTheme.typography.subtitle2.copy(
                    color = MaterialTheme.colors.error
                  )
                )
              }
            }
            Spacer(modifier = Modifier.preferredHeightIn(minHeight = 8.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.Center
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
