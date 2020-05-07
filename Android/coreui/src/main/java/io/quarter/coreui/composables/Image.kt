package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.ui.foundation.Image
import androidx.ui.graphics.BlendMode
import androidx.ui.graphics.Color
import androidx.ui.graphics.ColorFilter
import androidx.ui.res.loadImageResource
import androidx.ui.res.loadVectorResource

@Composable
fun LoadImage(imageResId: Int, tint: Color? = null) {
  loadImageResource(imageResId).resource.resource?.let {
    Image(image = it)
    Image(
      image = it,
      colorFilter = tint?.let { ColorFilter(color = it, blendMode = BlendMode.color) }
    )
  }
}

@Composable
fun LoadVector(imageResId: Int, tint: Color? = null) {
  loadVectorResource(imageResId).resource.resource?.let {
    // DrawVector(
    //     vectorImage = it,
    //     tintColor = tint ?: Color.Black
    // )
  }
}
