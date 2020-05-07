package io.quarter.client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Providers
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import com.github.zsoltk.compose.backpress.AmbientBackPressHandler
import com.github.zsoltk.compose.backpress.BackPressHandler
import com.github.zsoltk.compose.savedinstancestate.BundleScope
import com.github.zsoltk.compose.savedinstancestate.saveAmbient
import io.quarter.client.root.Root
import io.quarter.client.root.RootViewModel

class RootActivity : AppCompatActivity() {
  private val backPressHandler = BackPressHandler()

  private val rootViewModel = RootViewModel()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MaterialTheme(colors) {
        Providers(AmbientBackPressHandler provides backPressHandler) {
          BundleScope(savedInstanceState) {
            Root.Content(
              defaultRouting = if (rootViewModel.isAuthorized)
                Root.Routing.LoggedIn
              else
                Root.Routing.LoggedOut
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
