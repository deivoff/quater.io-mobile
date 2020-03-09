package io.quarter.client.root

import android.app.Activity
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import com.github.zsoltk.compose.router.Router
import dev.steelahhh.coreui.extensions.hideKeyboard
import io.quarter.client.loggedin.LoggedIn
import io.quarter.client.loggedout.LoggedOut
import io.quarter.client.loggedout.register.RegisterViewModel

interface Root {
    sealed class Routing {
        object LoggedOut : Routing()
        object LoggedIn : Routing()
    }

    companion object {
        @Composable
        fun Content(
            defaultRouting: Routing = Routing.LoggedOut,
            registerViewModel: RegisterViewModel
        ) {
            val context = ContextAmbient.current
            Router(defaultRouting) { backStack ->
                hideKeyboard(context as Activity)
                when (val routing = backStack.last()) {
                    Routing.LoggedOut -> LoggedOut.Content(
                        defaultRouting = LoggedOut.Routing.Splash(
                            onAuthorized = { backStack.newRoot(Routing.LoggedIn) }
                        ),
                        registerViewModel = registerViewModel
                    )
                    Routing.LoggedIn -> LoggedIn.Content()
                }
            }
        }
    }
}
