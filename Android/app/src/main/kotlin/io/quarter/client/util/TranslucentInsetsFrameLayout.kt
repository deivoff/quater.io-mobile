package io.quarter.client.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.updatePadding
import dev.steelahhh.coreui.WindowInsetsHolder
import dev.steelahhh.coreui.extensions.darkenColor
import io.quarter.client.R

class TranslucentInsetsFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var statusBarHeight = 0
    private val statusBarPaint = Paint()
    private var drawStatusBar: Boolean = false

    fun updateStatusBar(
        height: Int,
        @ColorRes colorRes: Int,
        visible: Boolean
    ) {
        val color = darkenColor(ContextCompat.getColor(context, colorRes), 0.08f)
        statusBarHeight = height
        statusBarPaint.color = color
        drawStatusBar = visible
        if (visible) {
            statusBarPaint.color = color
        } else {
            statusBarPaint.color = Color.parseColor("#14000000") // 8% of black
        }
        updatePadding(top = if (drawStatusBar) statusBarHeight else 0)
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        canvas.drawRect(0f, 0f, width.toFloat(), statusBarHeight.toFloat(), statusBarPaint)
    }

    override fun hasOverlappingRendering() = false

    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            WindowInsetsHolder.newInsets(
                Rect(
                    insets.systemWindowInsetLeft,
                    insets.systemWindowInsetTop,
                    insets.systemWindowInsetRight,
                    insets.systemWindowInsetBottom
                )
            )
            val child = getChildAt(0)
            val ignoredHeight = when (child) {
                is ViewGroup -> {
                    val navigation = child.findViewById<View>(R.id.rootNavigation)
                    navigation?.height ?: 0
                }
                else -> 0
            }
            val bottom = when (insets.systemWindowInsetBottom) {
                0 -> 0
                else -> insets.systemWindowInsetBottom - ignoredHeight
            }
            updatePadding(bottom = bottom)
            super.onApplyWindowInsets(insets.consumeSystemWindowInsets())
        } else {
            insets
        }
    }
}
