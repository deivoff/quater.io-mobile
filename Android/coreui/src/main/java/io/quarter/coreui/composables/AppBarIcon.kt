package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.layout.LayoutSize
import androidx.ui.material.ripple.Ripple
import androidx.ui.unit.dp

@Composable
fun AppBarVector(vectorRes: Int, onClick: () -> Unit) {
    Ripple(radius = 20.dp, bounded = false) {
        Clickable(onClick = onClick) {
            Box(LayoutSize(48.dp)) {
                // Vector(vectorImage = vectorResource(id = vectorRes), tintColor = Color.Black)
            }
        }
    }
}
