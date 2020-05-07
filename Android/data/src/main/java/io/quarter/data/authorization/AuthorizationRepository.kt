package io.quarter.data.authorization

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.exception.ApolloException
import io.quarter.data.Exceptions
import io.quarter.data.LoginQuery

class AuthorizationRepository(private val apolloClient: ApolloClient) {

  suspend fun login(authorizationData: AuthorizationData): String? {
    val query = LoginQuery(
      authorizationData.login,
      authorizationData.password
    )

    // val result = apolloClient.query(query).toDeferred().await()

    try {
      return "some-token"
      // result.data()?.login?.let {
      //   return it.token
      // } ?: run {
      //   throw IllegalStateException("Data is corrupted")
      // }
    } catch (e: ApolloException) {
      throw Exceptions.NetworkException
    }
  }
}
