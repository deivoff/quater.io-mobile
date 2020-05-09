package io.quarter.client.loggedout.login

import android.app.Activity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.ContextAmbient
import androidx.ui.core.FocusManagerAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
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
import androidx.ui.livedata.observeAsState
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import androidx.ui.text.AnnotatedString
import androidx.ui.text.SpanStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextAlign
import androidx.ui.text.style.TextDecoration
import androidx.ui.unit.dp
import io.quarter.client.DependencyContextAmbient
import io.quarter.core.Strings
import io.quarter.coreui.composables.LoaderButton
import io.quarter.coreui.composables.PasswordTextInput
import io.quarter.coreui.composables.TextInput
import io.quarter.coreui.extensions.hideKeyboard

interface Login {
  companion object {
    @Composable
    fun Content(onBackClick: () -> Unit, onRegisterClick: () -> Unit, onLoggedIn: () -> Unit) {
      val viewModel = DependencyContextAmbient.current.loginViewModel
      val focusManager = FocusManagerAmbient.current
      val context = ContextAmbient.current
      val loginInput = state { LoginInput() }

      Column(
        modifier = Modifier.fillMaxSize()
      ) {
        val loginState = viewModel.loginViewState.observeAsState()
        if (loginState.value?.isSuccessfullyLoggedIn == true) onLoggedIn()

        TopAppBar(
          title = { Text(text = Strings.Authorization.loginTitle) },
          backgroundColor = Color.White,
          elevation = 4.dp,
          navigationIcon = {
            IconButton(onClick = onBackClick) {
              Icon(asset = Icons.Default.ArrowBack)
            }
          }
        )
        Column(
          modifier = Modifier.fillMaxSize().padding(16.dp),
          verticalArrangement = Arrangement.Center
        ) {
          Text(
            modifier = Modifier.fillMaxWidth(),
            text = Strings.brand,
            style = MaterialTheme.typography.h2.copy(
              textAlign = TextAlign.Center
            )
          )
          Spacer(modifier = Modifier.preferredHeightIn(minHeight = 48.dp))
          TextInput(
            identifier = "LoginField",
            hint = Strings.Authorization.name,
            value = loginInput.value.login,
            onImeAction = { focusManager.requestFocusById("PasswordField") }
          ) {
            loginInput.value.login = it
          }
          Column(verticalArrangement = Arrangement.Bottom) {
            PasswordTextInput(
              identifier = "PasswordField",
              hint = Strings.Authorization.password,
              value = loginInput.value.password,
              onImeAction = { action ->
                if (action == ImeAction.Done) hideKeyboard(context as Activity)
              },
              layoutModifier = Modifier.padding(bottom = 4.dp)
            ) {
              loginInput.value.password = it
            }
            Clickable(onClick = {}) {
              Text(
                modifier = Modifier.fillMaxWidth(),
                text = Strings.Authorization.forgotPassword,
                style = MaterialTheme.typography.subtitle2.copy(
                  fontWeight = FontWeight.Normal,
                  textAlign = TextAlign.End,
                  color = MaterialTheme.colors.secondary
                )
              )
            }
            Spacer(modifier = Modifier.preferredHeightIn(minHeight = 12.dp))
          }
          LoaderButton(
            text = Strings.Authorization.login,
            isLoading = loginState.value?.isLoading == true,
            isEnabled = !loginInput.value.isEmpty,
            onClick = {
              viewModel.login(loginInput.value.asData)
            }
          )
          if (loginState.value?.isError == true) {
            Column(modifier = Modifier.padding(4.dp)) {
              Text(
                text = Strings.Authorization.loginError,
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
              text = "${Strings.Authorization.noAccount} ",
              style = MaterialTheme.typography.body1.copy(
                color = Color.Black.copy(alpha = 0.5f)
              )
            )
            Clickable(onClick = onRegisterClick) {
              val createText = AnnotatedString(
                text = Strings.create,
                spanStyle = SpanStyle(
                  color = Color.Black,
                  textDecoration = TextDecoration.Underline
                )
              )
              Text(text = createText, style = MaterialTheme.typography.body1)
            }
          }
        }
      }
    }
  }
}
