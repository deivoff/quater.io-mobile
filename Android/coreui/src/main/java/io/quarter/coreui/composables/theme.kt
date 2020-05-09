package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.lightColorPalette

/*
 * Author: steelahhh
 * 9/5/20
 */

val lightColors = lightColorPalette(
  primary = Color.Black,
  onPrimary = Color.White,
  secondary = Color.DarkGray,
  surface = Color.White
)

@Composable
fun IOTMaterialTheme(content: @Composable() () -> Unit) {
  MaterialTheme(colors = lightColors, content = content)
}
