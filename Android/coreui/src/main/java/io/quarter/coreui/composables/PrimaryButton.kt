package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.tag
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Shape
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.preferredHeightIn
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun PrimaryButton(
  text: String,
  modifier: Modifier = Modifier.tag("primaryButton$text"),
  shape: Shape = RoundedCornerShape(8.dp),
  isEnabled: Boolean = true,
  onClick: (() -> Unit)? = {}
) = Button(
  elevation = 6.dp,
  modifier = Modifier.fillMaxWidth().preferredHeightIn(minHeight = 48.dp) + modifier,
  shape = shape,
  backgroundColor = MaterialTheme.colors.run { if (isEnabled) primary else secondary },
  onClick = onClick.takeIf { isEnabled } ?: {}
) {
  Text(
    text = text,
    style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colors.onPrimary)
  )
}
