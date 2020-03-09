package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.ui.foundation.DrawImage
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.res.loadImageResource
import androidx.ui.res.loadVectorResource

@Composable
fun LoadImage(imageResId: Int, tint: Color? = null) {
    loadImageResource(imageResId).resource.resource?.let {
        DrawImage(
            image = it,
            tint = tint
        )
    }
}

@Composable
fun LoadVector(imageResId: Int, tint: Color? = null) {
    loadVectorResource(imageResId).resource.resource?.let {
        DrawVector(
            vectorImage = it,
            tintColor = tint ?: Color.Black
        )
    }
}
