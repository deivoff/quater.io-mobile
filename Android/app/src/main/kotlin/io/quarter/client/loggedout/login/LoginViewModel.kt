package io.quarter.client.loggedout.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.quarter.core.modify
import io.quarter.data.DataModule
import io.quarter.data.KeyValueStorage
import io.quarter.data.authorization.AuthorizationData
import io.quarter.data.authorization.AuthorizationRepository
import kotlinx.coroutines.launch

class LoginViewModel(
  private val authorizationRepository: AuthorizationRepository = DataModule.authRepo,
  private val keyValueStorage: KeyValueStorage = DataModule.keyValueStorage
) : ViewModel() {

  val loginViewState: MutableLiveData<LoginViewState> = MutableLiveData()

  init {
    loginViewState.value = LoginViewState()
  }

  fun login(authorizationData: AuthorizationData) {
    loginViewState.modify { copy(isLoading = true, isError = false) }

    viewModelScope.launch {
      try {
        val token = authorizationRepository.login(authorizationData)
        keyValueStorage.putString("token", token)
        loginViewState.modify {
          copy(
            isLoading = false,
            isError = false,
            isSuccessfullyLoggedIn = true
          )
        }
      } catch (e: Exception) {
        e.printStackTrace()
        loginViewState.modify { copy(isLoading = false, isError = true) }
      }
    }
  }

  fun logout() = keyValueStorage.clear("token")

  data class LoginViewState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccessfullyLoggedIn: Boolean = false
  )
}
