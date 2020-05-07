package io.quarter.data.authorization

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.exception.ApolloException
import io.quarter.data.Exceptions
import io.quarter.data.LoginQuery
import timber.log.Timber

class AuthorizationRepository(private val apolloClient: ApolloClient) {

  suspend fun login(authorizationInput: AuthorizationInput): String? {
    val query = LoginQuery(
      authorizationInput.login,
      authorizationInput.password
    )

    val result = apolloClient.query(query).toDeferred().await()

    try {
      Timber.d("${result.data()}")
      result.data()?.login?.let {
        return it.token
      } ?: run {
        throw IllegalStateException("Data is corrupted")
      }
    } catch (e: ApolloException) {
      throw Exceptions.NetworkException
    }
  }
}
