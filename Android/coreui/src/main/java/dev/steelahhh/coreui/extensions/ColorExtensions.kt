package dev.steelahhh.coreui.extensions

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.FloatRange
import androidx.core.graphics.ColorUtils

@ColorInt
fun darkenColor(
    @ColorInt color: Int,
    @FloatRange(from = 0.0, to = 1.0) degree: Float
): Int = ColorUtils.blendARGB(color, Color.BLACK, degree)
