package io.quarter.client.loggedout.register

data class RegisterViewState(
    val email: String = "",
    val password: String = "",
    val lastName: String = "",
    val firstName: String = "",
    val patronymic: String = ""
) {
    fun isEmpty() =
        email.isEmpty() || password.isEmpty() || lastName.isEmpty() || firstName.isEmpty()
}
