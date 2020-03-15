package io.quarter.core

import androidx.lifecycle.MutableLiveData

/*
 * Author: steelahhh
 * 9/3/20
 */

inline fun <T> MutableLiveData<T>.modify(async: Boolean = true, crossinline block: T.() -> T) {
    if (async) postValue(block(value!!))
    else value = block(value!!)
}
