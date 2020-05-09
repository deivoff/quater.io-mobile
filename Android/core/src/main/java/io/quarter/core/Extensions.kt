package io.quarter.core

import androidx.lifecycle.MutableLiveData

/*
 * Author: steelahhh
 * 9/3/20
 */

val Any.prettyPrint get() = toString()
  .replace("(", "(\n ")
  .replace(",", ",\n")
  .replace(")", "\n)")

inline fun <T> MutableLiveData<T>.modify(async: Boolean = true, crossinline block: T.() -> T) {
  if (async) postValue(block(value!!))
  else value = block(value!!)
}
