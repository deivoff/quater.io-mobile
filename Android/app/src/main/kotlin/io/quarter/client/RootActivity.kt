package io.quarter.client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Providers
import androidx.ui.core.setContent
import com.github.zsoltk.compose.backpress.AmbientBackPressHandler
import com.github.zsoltk.compose.backpress.BackPressHandler
import com.github.zsoltk.compose.savedinstancestate.BundleScope
import com.github.zsoltk.compose.savedinstancestate.saveAmbient
import io.quarter.client.loggedout.login.LoginViewModel
import io.quarter.client.loggedout.register.RegisterViewModel
import io.quarter.client.root.Root
import io.quarter.client.root.RootViewModel
import io.quarter.coreui.composables.IOTMaterialTheme

class RootActivity : AppCompatActivity() {
  private val backPressHandler = BackPressHandler()

  private val dependencyContext = object : DependencyContext {
    override val loginViewModel: LoginViewModel get() = LoginViewModel()
    override val registerViewModel: RegisterViewModel get() = RegisterViewModel()
    override val rootViewModel: RootViewModel = RootViewModel()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      IOTMaterialTheme {
        Providers(
          AmbientBackPressHandler provides backPressHandler,
          DependencyContextAmbient provides dependencyContext
        ) {
          val dependencyContext = DependencyContextAmbient.current
          BundleScope(savedInstanceState) {
            Root.Content(
              defaultRouting = dependencyContext.rootViewModel.defaultRouting
            )
          }
        }
      }
    }
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.saveAmbient()
  }

  override fun onBackPressed() {
    if (!backPressHandler.handle()) super.onBackPressed()
  }
}
