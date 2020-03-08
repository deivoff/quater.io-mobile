package io.quarter.client.loggedout

import androidx.compose.Composable
import com.github.zsoltk.compose.router.Router
import io.quarter.client.loggedout.login.Login
import io.quarter.client.loggedout.register.Register

interface LoggedOut {

    sealed class Routing {
        data class Splash(val onAuthorized: () -> Unit) : Routing()
        data class Login(val onAuthorized: () -> Unit) : Routing()
        data class Register(val onAuthorized: () -> Unit) : Routing()
    }

    companion object {
        @Composable
        fun Content(defaultRouting: Routing) {
            Router(defaultRouting) { backStack ->
                when (val currentRouting = backStack.last()) {
                    is Routing.Splash -> Splash.Content(
                        loginClick = {
                            backStack.push(Routing.Login(currentRouting.onAuthorized))
                        },
                        registerClick = {
                            backStack.push(Routing.Register(currentRouting.onAuthorized))
                        }
                    )
                    is Routing.Login -> Login.Content(
                        onBackClick = { backStack.pop() },
                        onRegisterClick = {
                            backStack.pop()
                            backStack.push(Routing.Register(currentRouting.onAuthorized))
                        },
                        onLoginClick = currentRouting.onAuthorized
                    )
                    is Routing.Register -> Register.Content(
                        onBackClick = { backStack.pop() },
                        onLoginClick = {
                            backStack.pop()
                            backStack.push(Routing.Login(currentRouting.onAuthorized))
                        }
                    )
                }
            }
        }
    }
}
