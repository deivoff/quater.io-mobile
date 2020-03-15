package io.quarter.data

import java.lang.IllegalStateException

object Exceptions {

    object NetworkException : IllegalStateException("No network connection")
}
