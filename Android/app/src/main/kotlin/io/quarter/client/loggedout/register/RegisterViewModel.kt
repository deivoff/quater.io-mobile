package io.quarter.client.loggedout.register

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.quarter.core.modify
import io.quarter.data.DataModule
import io.quarter.data.register.RegisterInput
import io.quarter.data.register.RegisterRepository
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerRepository: RegisterRepository = DataModule.registerRepo
) : ViewModel() {

    val registerViewState: MutableLiveData<RegisterViewState> = MutableLiveData()

    init {
        registerViewState.value = RegisterViewState()
    }

    fun register(value: RegisterInput) {
        if (!Patterns.EMAIL_ADDRESS.matcher(value.email).matches()) {
            registerViewState.modify { copy(isEmailInvalid = true) }
            return
        }

        if (value.password.isEmpty()) {
            return
        }

        registerViewState.modify { copy(isLoading = true, isEmailInvalid = false) }

        viewModelScope.launch {
            try {
                val id = registerRepository.register(value)
                registerViewState.modify { copy(isRegisterSuccess = true, isLoading = false) }
            } catch (e: Exception) {
                registerViewState.modify {
                    copy(
                        isRegisterSuccess = false,
                        isLoading = false,
                        isError = true
                    )
                }
                e.printStackTrace()
            }
        }
    }

    data class RegisterViewState(
        val isEmailInvalid: Boolean? = null,
        val isRegisterSuccess: Boolean? = null,
        val isLoading: Boolean = false,
        val isError: Boolean = false
    )
}
