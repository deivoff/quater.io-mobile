package io.quarter.coreui.extensions

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.compose.MutableState

fun <T> MutableState<T>.modify(block: T.() -> T) {
  value = block(value)
}

fun hideKeyboard(activity: Activity) {
  val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
  var view = activity.currentFocus
  if (view == null) view = View(activity)
  imm.hideSoftInputFromWindow(view.windowToken, 0)
}
