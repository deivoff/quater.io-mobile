package io.quarter.client.root

import androidx.lifecycle.ViewModel
import io.quarter.data.DataModule
import io.quarter.data.KeyValueStorage

class RootViewModel(
  private val keyValueStorage: KeyValueStorage = DataModule.keyValueStorage
) : ViewModel() {
  private val isAuthorized get() = !keyValueStorage.getString("token").isNullOrEmpty()

  val defaultRouting get() = if (isAuthorized) Root.Routing.LoggedIn else Root.Routing.LoggedOut
}
