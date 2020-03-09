package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.LayoutSize
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp

@Composable
fun AppBarVector(vectorRes: Int, onClick: () -> Unit) {
    Ripple(radius = 20.dp, bounded = false) {
        Clickable(onClick = onClick) {
            Box(LayoutSize(48.dp)) {
                DrawVector(vectorImage = vectorResource(id = vectorRes), tintColor = Color.Black)
            }
        }
    }
}
