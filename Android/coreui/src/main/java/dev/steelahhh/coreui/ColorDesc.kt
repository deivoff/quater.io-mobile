package dev.steelahhh.coreui

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import dev.steelahhh.coreui.extensions.getColorCompat

/*
 * Author: steelahhh
 * 7/3/20
 */

abstract class ColorDesc {
    data class Resource(@ColorRes val res: Int) : ColorDesc() {
        override fun create(context: Context): Int = context.getColorCompat(res)
    }

    data class Raw(@ColorInt val color: Int) : ColorDesc() {
        override fun create(context: Context): Int = color
    }

    abstract fun create(context: Context): Int
}
