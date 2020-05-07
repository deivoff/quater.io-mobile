package io.quarter.data.register

import com.apollographql.apollo.ApolloClient
import io.quarter.data.Exceptions
import io.quarter.data.RegisterMutation
import io.quarter.data.type.UserInput

class RegisterRepository(private val apolloClient: ApolloClient) {
  suspend fun register(
    registerData: RegisterData
  ): String? {
    val mutation = RegisterMutation(
      UserInput(
        email = registerData.email,
        familyName = registerData.lastName,
        givenName = registerData.firstName,
        fatherName = registerData.patronymic,
        password = registerData.password
      )
    )

    try {
      return "123"
    } catch (e: Exception) {
      throw Exceptions.NetworkException
    }
  }
}
