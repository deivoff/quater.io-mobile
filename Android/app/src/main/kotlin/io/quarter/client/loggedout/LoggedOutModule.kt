package io.quarter.client.loggedout

import io.quarter.client.loggedout.register.RegisterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loggedOutModule = module {
    viewModel { RegisterViewModel() }
}
