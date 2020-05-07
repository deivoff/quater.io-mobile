package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.ui.core.LayoutTag
import androidx.ui.core.Modifier
import androidx.ui.core.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Shape
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutWidth
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun PrimaryButton(
  text: String,
  modifier: Modifier = LayoutTag("primaryButton$text"),
  shape: Shape = RoundedCornerShape(8.dp),
  isEnabled: Boolean = true,
  onClick: (() -> Unit)? = {}
) = Button(
  elevation = 6.dp,
  modifier = LayoutWidth.Fill + LayoutHeight.Min(48.dp) + modifier,
  shape = shape,
  backgroundColor = MaterialTheme.colors().run { if (isEnabled) primary else secondary },
  onClick = onClick.takeIf { isEnabled } ?: {}
) {
  Text(
    text = text,
    style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colors().onPrimary)
  )
}
