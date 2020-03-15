package io.quarter.core

/*
 * Author: steelahhh
 * 7/3/20
 */

object Strings {
    const val create = "Создать"
    const val error = "Ошибка"
    const val tryAgain = "Попробуйте еще раз."

    object Authorization {
        const val login = "Войти"
        const val register = "Зарегестрироваться"

        const val loginTitle = "Авторизация"
        const val registerTitle = "Регистрация"

        const val noAccount = "Нет аккаунта?"
        const val password = "Пароль"
        const val name = "Логин"
        const val forgotPassword = "Забыли пароль?"

        const val loginError = "Ошибка при авторизации"
    }

    object Register {
        const val email = "Электронный адрес"
        const val lastName = "Фамилия"
        const val firstName = "Имя"
        const val patronymic = "Отчество"

        const val alreadyClient = "Вы наш клиент?"

        const val registerError = "Ошибка при регистрации"
        const val emailError = "Некорректный E-mail"
    }
}
