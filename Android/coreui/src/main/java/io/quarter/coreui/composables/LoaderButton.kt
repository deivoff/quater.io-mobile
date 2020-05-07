package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.tag
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Shape
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.height
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.unit.dp

/*
 * Author: steelahhh
 * 9/3/20
 */

@Composable
fun LoaderButton(
  text: String,
  isLoading: Boolean = false,
  modifier: Modifier = Modifier.tag("loaderButton$text"),
  shape: Shape = RoundedCornerShape(8.dp),
  isEnabled: Boolean = true,
  onClick: () -> Unit = {}
) {
  Column(
    modifier = Modifier.fillMaxWidth()
  ) {
    if (isLoading) {
      Surface(shape = shape, color = MaterialTheme.colors.primary) {
        Row(
          modifier = Modifier.fillMaxSize(),
          horizontalArrangement = Arrangement.Center
        ) {
          Column(
            modifier = Modifier.height(48.dp),
            verticalArrangement = Arrangement.Center
          ) {
            Row(
              modifier = Modifier.height(48.dp),
              horizontalArrangement = Arrangement.Center
            ) {
              CircularProgressIndicator(color = MaterialTheme.colors.onPrimary)
            }
          }
        }
      }
    } else {
      PrimaryButton(
        text = text.takeIf { !isLoading } ?: "",
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        isEnabled = isEnabled,
        onClick = onClick.takeIf { !isLoading }
      )
    }
  }
}
