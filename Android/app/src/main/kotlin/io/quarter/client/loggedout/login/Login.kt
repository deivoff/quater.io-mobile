package io.quarter.client.loggedout.login

import android.app.Activity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.ContextAmbient
import androidx.ui.core.FocusManagerAmbient
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.text.AnnotatedString
import androidx.ui.text.SpanStyle
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextAlign
import androidx.ui.text.style.TextDecoration
import androidx.ui.unit.dp
import io.quarter.client.R
import io.quarter.core.Strings
import io.quarter.coreui.composables.AppBarVector
import io.quarter.coreui.composables.PasswordTextInput
import io.quarter.coreui.composables.PrimaryButton
import io.quarter.coreui.composables.TextInput
import io.quarter.coreui.extensions.hideKeyboard
import io.quarter.coreui.extensions.modify

interface Login {
    companion object {
        @Composable
        fun Content(
            onBackClick: () -> Unit,
            onRegisterClick: () -> Unit,
            onLoginClick: () -> Unit = {}
        ) {
            val focusManager = FocusManagerAmbient.current
            val context = ContextAmbient.current
            val loginState = state { LoginViewState() }

            Column(
                modifier = LayoutWidth.Fill + LayoutHeight.Fill
            ) {
                TopAppBar(
                    title = { Text(text = Strings.Authorization.loginTitle) },
                    color = Color.White,
                    elevation = 4.dp,
                    navigationIcon = {
                        AppBarVector(vectorRes = R.drawable.ic_arrow_back, onClick = onBackClick)
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
                        value = loginState.value.login,
                        onImeAction = { focusManager.requestFocusById("PasswordField") }
                    ) {
                        loginState.modify { copy(login = it) }
                    }
                    Column(arrangement = Arrangement.End) {
                        PasswordTextInput(
                            identifier = "PasswordField",
                            hint = Strings.Authorization.password,
                            value = loginState.value.password,
                            onImeAction = { action ->
                                if (action == ImeAction.Done) hideKeyboard(context as Activity)
                            },
                            layoutModifier = LayoutPadding(bottom = 4.dp)
                        ) {
                            loginState.modify { copy(password = it) }
                        }
                        Clickable {
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
                    PrimaryButton(
                        text = Strings.Authorization.login,
                        isEnabled = !loginState.value.isEmpty,
                        onClick = onLoginClick
                    )
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
