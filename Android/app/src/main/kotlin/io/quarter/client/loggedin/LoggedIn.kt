package io.quarter.client.loggedin

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.surface.Surface
import com.github.zsoltk.compose.router.Router

interface LoggedIn {
    sealed class Routing {
        object Home : Routing()
    }

    companion object {
        @Composable
        fun Content(defaultRouting: Routing = Routing.Home) {
            Router(defaultRouting = defaultRouting) { backStack ->
                when (backStack.last()) {
                    else -> Surface(color = Color.Blue) {
                    }
                }
            }
        }
    }
}
