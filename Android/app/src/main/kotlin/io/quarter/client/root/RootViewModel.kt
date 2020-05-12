package io.quarter.client.root

import androidx.lifecycle.ViewModel
import io.quarter.client.loggedin.LoggedInRootKey
import io.quarter.client.loggedout.SplashKey
import io.quarter.data.DataModule
import io.quarter.data.KeyValueStorage

class RootViewModel(
  private val keyValueStorage: KeyValueStorage = DataModule.keyValueStorage
) : ViewModel() {
  private val isAuthorized get() = !keyValueStorage.getString("token").isNullOrEmpty()

  val defaultKey get() = if (isAuthorized) LoggedInRootKey() else SplashKey()
}
