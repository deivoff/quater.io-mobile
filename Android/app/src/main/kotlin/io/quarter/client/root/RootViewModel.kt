package io.quarter.client.root

import androidx.lifecycle.ViewModel
import io.quarter.data.DataModule
import io.quarter.data.KeyValueStorage

class RootViewModel(
    private val keyValueStorage: KeyValueStorage = DataModule.keyValueStorage
) : ViewModel() {
    val isAuthorized get() = !keyValueStorage.getString("token").isNullOrEmpty()
}
