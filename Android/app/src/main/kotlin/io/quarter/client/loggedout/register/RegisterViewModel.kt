package io.quarter.client.loggedout.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    val registerProgress: MutableLiveData<Boolean> = MutableLiveData()

    init {
        registerProgress.value = false
    }

    fun register(value: RegisterViewState) {
        registerProgress.postValue(true)
    }
}