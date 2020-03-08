package io.quarter.client.loggedout.login

data class LoginViewState(
    val login: String = "",
    val password: String = ""
) {
    val isEmpty: Boolean get() = login.isEmpty() || password.isEmpty()
}
