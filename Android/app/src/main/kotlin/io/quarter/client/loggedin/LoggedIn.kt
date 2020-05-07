package io.quarter.client.loggedin

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.Spacer
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.text.style.TextAlign
import androidx.ui.unit.dp
import com.github.zsoltk.compose.router.Router
import io.quarter.client.DependencyContextAmbient
import io.quarter.coreui.composables.PrimaryButton

interface LoggedIn {
  sealed class Routing {
    object Home : Routing()
  }

  companion object {
    @Composable
    fun Content(
      defaultRouting: Routing = Routing.Home,
      onLogout: () -> Unit
    ) {
      val loginViewModel = DependencyContextAmbient.current.loginViewModel
      Router(defaultRouting = defaultRouting) { backStack ->
        when (backStack.last()) {
          else -> Column(
            modifier = Modifier.fillMaxHeight().padding(16.dp)
          ) {
            Text(
              text = "Authorized", style = MaterialTheme.typography.h3.copy(
                textAlign = TextAlign.Center
              )
            )
            Spacer(modifier = Modifier.weight(weight = 1f))
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
