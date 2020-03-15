package io.quarter.data.register

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import io.quarter.data.Exceptions
import io.quarter.data.RegisterMutation
import io.quarter.data.type.UserInput

class RegisterRepository(private val apolloClient: ApolloClient) {
    suspend fun register(
        registerInput: RegisterInput
    ): String? {
        val mutation = RegisterMutation(
            UserInput(
                email = registerInput.email,
                familyName = registerInput.lastName,
                givenName = registerInput.firstName,
                fatherName = registerInput.patronymic,
                password = registerInput.password
            )
        )

        val userData = apolloClient.mutate(mutation).toDeferred().await()

        try {
            userData.data()?.createUser?.let {
                return it.id
            } ?: run {
                throw IllegalStateException("Data is corrupted")
            }
        } catch (e: Exception) {
            throw Exceptions.NetworkException
        }
    }
}
