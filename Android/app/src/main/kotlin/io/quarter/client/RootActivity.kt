package io.quarter.client

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Providers
import androidx.ui.core.setContent
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.SimpleStateChanger
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.navigator.Navigator
import io.quarter.client.loggedout.login.LoginViewModel
import io.quarter.client.loggedout.register.RegisterViewModel
import io.quarter.client.root.RootViewModel
import io.quarter.coreui.composables.IOTMaterialTheme

class RootActivity : AppCompatActivity(), SimpleStateChanger.NavigationHandler {
  private val dependencyContext = object : DependencyContext {
    override val loginViewModel: LoginViewModel get() = LoginViewModel()
    override val registerViewModel: RegisterViewModel get() = RegisterViewModel()
    override val rootViewModel: RootViewModel = RootViewModel()
  }
  private lateinit var backstack: Backstack
  private val backstackState = BackstackState(emptyList())

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val contentView = window.decorView.findViewById<ViewGroup>(android.R.id.content)

    backstack = Navigator.configure()
      .setStateChanger(SimpleStateChanger(this))
      .setDeferredInitialization(true)
      .install(
        this,
        contentView,
        History.of(dependencyContext.rootViewModel.defaultKey)
      )

    setContent {
      IOTMaterialTheme {
        Providers(
          DependencyContextAmbient provides dependencyContext,
          BackstackAmbient provides backstack
        ) {
          backstackState.screens.lastOrNull()?.content()
        }
      }
    }

    Navigator.executeDeferredInitialization(this)
  }

  override fun onBackPressed() {
    if (!Navigator.onBackPressed(this)) {
      super.onBackPressed()
    }
  }

  override fun onNavigationEvent(stateChange: StateChange) {
    backstackState.screens = stateChange.getNewKeys()
  }
}
