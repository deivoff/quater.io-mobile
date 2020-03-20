package io.quarter.client.loggedout.login

import android.app.Activity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.ContextAmbient
import androidx.ui.core.FocusManagerAmbient
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Icon
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
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextAlign
import androidx.ui.text.style.TextDecoration
import androidx.ui.unit.dp
import io.quarter.core.Strings
import io.quarter.coreui.composables.LoaderButton
import io.quarter.coreui.composables.PasswordTextInput
import io.quarter.coreui.composables.TextInput
import io.quarter.coreui.extensions.hideKeyboard
import io.quarter.coreui.extensions.modify
import io.quarter.coreui.observe
import io.quarter.data.authorization.AuthorizationInput

interface Login {
    companion object {
        @Composable
        fun Content(
            viewModel: LoginViewModel = LoginViewModel(),
            onBackClick: () -> Unit,
            onRegisterClick: () -> Unit,
            onLoggedIn: () -> Unit
        ) {
            val focusManager = FocusManagerAmbient.current
            val context = ContextAmbient.current
            val loginInput = state { AuthorizationInput() }

            val loginState = observe(data = viewModel.loginViewState)

            if (loginState?.isSuccessfullyLoggedIn == true) onLoggedIn()

            Column(
                modifier = LayoutWidth.Fill + LayoutHeight.Fill
            ) {
                TopAppBar(
                    title = { Text(text = Strings.Authorization.loginTitle) },
                    color = Color.White,
                    elevation = 4.dp,
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(icon = Icons.Default.ArrowBack)
                        }
                    }
                )
                Column(
                    modifier = LayoutWidth.Fill + LayoutHeight.Fill + LayoutPadding(16.dp),
                    arrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = LayoutWidth.Fill,
                        text = "quarter.io",
                        style = MaterialTheme.typography().h2.copy(
                            textAlign = TextAlign.Center
                        )
                    )
                    Spacer(modifier = LayoutHeight.Min(48.dp))
                    TextInput(
                        identifier = "LoginField",
                        hint = Strings.Authorization.name,
                        value = loginInput.value.login,
                        onImeAction = { focusManager.requestFocusById("PasswordField") }
                    ) {
                        loginInput.modify { copy(login = it) }
                    }
                    Column(arrangement = Arrangement.Bottom) {
                        PasswordTextInput(
                            identifier = "PasswordField",
                            hint = Strings.Authorization.password,
                            value = loginInput.value.password,
                            onImeAction = { action ->
                                if (action == ImeAction.Done) hideKeyboard(context as Activity)
                            },
                            layoutModifier = LayoutPadding(bottom = 4.dp)
                        ) {
                            loginInput.modify { copy(password = it) }
                        }
                        Clickable(onClick = {}) {
                            Text(
                                modifier = LayoutWidth.Fill,
                                text = Strings.Authorization.forgotPassword,
                                style = MaterialTheme.typography().subtitle2.copy(
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.End,
                                    color = MaterialTheme.colors().secondary
                                )
                            )
                        }
                        Spacer(modifier = LayoutHeight.Min(12.dp))
                    }
                    LoaderButton(
                        text = Strings.Authorization.login,
                        isLoading = loginState?.isLoading == true,
                        isEnabled = !loginInput.value.isEmpty,
                        onClick = {
                            viewModel.login(loginInput.value)
                        }
                    )
                    if (loginState?.isError == true) {
                        Column(modifier = LayoutPadding(4.dp)) {
                            Text(
                                text = Strings.Authorization.loginError,
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
                            text = "${Strings.Authorization.noAccount} ",
                            style = TextStyle(color = Color.Black.copy(alpha = 0.5f))
                        )
                        Clickable(onClick = onRegisterClick) {
                            val createText = AnnotatedString(
                                text = Strings.create,
                                spanStyle = SpanStyle(
                                    color = Color.Black,
                                    textDecoration = TextDecoration.Underline
                                )
                            )
                            Text(text = createText)
                        }
                    }
                }
            }
        }
    }
}
