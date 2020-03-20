package io.quarter.client.loggedin

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.Spacer
import androidx.ui.material.MaterialTheme
import androidx.ui.text.style.TextAlign
import androidx.ui.unit.dp
import com.github.zsoltk.compose.router.Router
import io.quarter.client.loggedout.login.LoginViewModel
import io.quarter.coreui.composables.PrimaryButton

interface LoggedIn {
    sealed class Routing {
        object Home : Routing()
    }

    companion object {
        @Composable
        fun Content(
            defaultRouting: Routing = Routing.Home,
            loginViewModel: LoginViewModel,
            onLogout: () -> Unit
        ) {
            Router(defaultRouting = defaultRouting) { backStack ->
                when (backStack.last()) {
                    else -> Column(
                        modifier = LayoutHeight.Fill + LayoutPadding(16.dp)
                    ) {
                        Text(
                            text = "Authorized", style = MaterialTheme.typography().h3.copy(
                                textAlign = TextAlign.Center
                            )
                        )
                        Spacer(modifier = LayoutWeight(1f))
                        PrimaryButton(
                            text = "Выйти",
                            onClick = {
                                loginViewModel.logout()
                                onLogout()
                            }
                        )
                    }
                }
            }
        }
    }
}
