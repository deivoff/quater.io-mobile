package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.vector.VectorPainter
import androidx.ui.layout.size
import androidx.ui.material.ripple.ripple
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp

@Composable
fun AppBarVector(vectorRes: Int, onClick: () -> Unit) {
  Clickable(onClick = onClick) {
    Box(modifier = Modifier.size(48.dp).ripple(bounded = false, radius = 20.dp)) {
      VectorPainter(asset = vectorResource(id = vectorRes))
    }
  }
}
