package io.quarter.data

import android.content.SharedPreferences

/*
 * Author: steelahhh
 * 9/3/20
 */

class KeyValueStorage(
    private val sharedPreferences: SharedPreferences
) {
    fun getString(key: String) = sharedPreferences.getString(key, null)

    fun putString(key: String, value: String?) = sharedPreferences.edit()
        .putString(key, value)
        .commit()

    fun clear(key: String) {
        sharedPreferences.edit().remove(key).commit()
    }
}
