package io.quarter.data

import android.content.Context
import com.apollographql.apollo.ApolloClient
import io.quarter.data.authorization.AuthorizationRepository
import io.quarter.data.register.RegisterRepository
import okhttp3.OkHttpClient

object DataModule {
  val okHttpClient = OkHttpClient.Builder().build()

  val apolloClient: ApolloClient = ApolloClient.builder()
    .serverUrl("http://64.225.98.207/")
    .okHttpClient(okHttpClient)
    .build()

  val registerRepo = RegisterRepository(apolloClient = apolloClient)

  val authRepo = AuthorizationRepository(apolloClient = apolloClient)

  lateinit var keyValueStorage: KeyValueStorage

  fun init(context: Context) {
    keyValueStorage = KeyValueStorage(
      context.getSharedPreferences("quarterio", Context.MODE_PRIVATE)
    )
  }
}
