package io.quarter.client.root

import android.app.Activity
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import com.github.zsoltk.compose.router.Router
import io.quarter.client.loggedin.LoggedIn
import io.quarter.client.loggedout.LoggedOut
import io.quarter.coreui.extensions.hideKeyboard

interface Root {
  sealed class Routing {
    object LoggedOut : Routing()
    object LoggedIn : Routing()
  }

  companion object {
    @Composable
    fun Content(
      defaultRouting: Routing = Routing.LoggedOut
    ) {
      val context = ContextAmbient.current
      Router(defaultRouting) { backStack ->
        hideKeyboard(context as Activity)
        when (backStack.last()) {
          is Routing.LoggedOut -> LoggedOut.Content(
            defaultRouting = LoggedOut.Routing.Splash(
              onAuthorized = { backStack.newRoot(Routing.LoggedIn) }
            )
          )
          is Routing.LoggedIn -> LoggedIn.Content {
            backStack.newRoot(Routing.LoggedOut)
          }
        }
      }
    }
  }
}
