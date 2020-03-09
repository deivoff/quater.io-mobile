package io.quarter.client.loggedout.register

import android.app.Activity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.ContextAmbient
import androidx.ui.core.FocusManagerAmbient
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
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
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.TopAppBar
import androidx.ui.text.AnnotatedString
import androidx.ui.text.SpanStyle
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextDecoration
import androidx.ui.unit.dp
import dev.steelahhh.coreui.composables.AppBarVector
import dev.steelahhh.coreui.composables.LoaderButton
import dev.steelahhh.coreui.composables.PasswordTextInput
import dev.steelahhh.coreui.composables.PrimaryButton
import dev.steelahhh.coreui.composables.TextInput
import dev.steelahhh.coreui.extensions.hideKeyboard
import dev.steelahhh.coreui.extensions.modify
import dev.steelahhh.coreui.observe
import io.quarter.client.R
import io.quarter.core.Strings

interface Register {
    companion object {
        @Composable
        fun Content(
            viewModel: RegisterViewModel,
            onBackClick: () -> Unit,
            onLoginClick: () -> Unit
        ) {
            val isLoading = observe(viewModel.registerProgress)

            Column(
                modifier = LayoutWidth.Fill + LayoutHeight.Fill
            ) {
                val focusManager = FocusManagerAmbient.current
                val context = ContextAmbient.current
                val registerState = state { RegisterViewState() }

                TopAppBar(
                    title = { Text(text = Strings.Authorization.registerTitle) },
                    color = Color.White,
                    elevation = 4.dp,
                    navigationIcon = {
                        AppBarVector(vectorRes = R.drawable.ic_arrow_back, onClick = onBackClick)
                    }
                )
                VerticalScroller {
                    Column(modifier = LayoutPadding(16.dp)) {
                        TextInput(
                            identifier = "EmailId",
                            hint = Strings.Register.email,
                            value = registerState.value.email,
                            onImeAction = { focusManager.requestFocusById("PasswordId") }
                        ) {
                            registerState.modify { copy(email = it) }
                        }
                        PasswordTextInput(
                            identifier = "PasswordId",
                            hint = Strings.Authorization.password,
                            value = registerState.value.password,
                            onImeAction = { focusManager.requestFocusById("LastNameId") }
                        ) {
                            registerState.modify { copy(password = it) }
                        }
                        TextInput(
                            identifier = "LastNameId",
                            hint = Strings.Register.lastName,
                            value = registerState.value.lastName,
                            onImeAction = { focusManager.requestFocusById("FirstNameId") }
                        ) {
                            registerState.modify { copy(lastName = it) }
                        }
                        TextInput(
                            identifier = "FirstNameId",
                            hint = Strings.Register.firstName,
                            value = registerState.value.firstName,
                            onImeAction = { focusManager.requestFocusById("PatronymicId") }
                        ) {
                            registerState.modify { copy(firstName = it) }
                        }
                        TextInput(
                            identifier = "PatronymicId",
                            hint = Strings.Register.patronymic,
                            value = registerState.value.patronymic,
                            imeAction = ImeAction.Done,
                            onImeAction = { action ->
                                if (action == ImeAction.Done) hideKeyboard(context as Activity)
                            }
                        ) {
                            registerState.modify { copy(patronymic = it) }
                        }
                        LoaderButton(
                            text = Strings.Authorization.register,
                            isLoading = isLoading == true,
                            isEnabled = !registerState.value.isEmpty(),
                            onClick = { viewModel.register(registerState.value) }
                        )
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
