package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.ui.core.LayoutTag
import androidx.ui.core.Modifier
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Shape
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Row
import androidx.ui.layout.Stack
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.MaterialTheme
import androidx.ui.unit.dp

/*
 * Author: steelahhh
 * 9/3/20
 */

@Composable
fun LoaderButton(
    text: String,
    isLoading: Boolean = false,
    modifier: Modifier = LayoutTag("loaderButton$text"),
    shape: Shape = RoundedCornerShape(8.dp),
    isEnabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Stack(
        modifier = LayoutHeight.Min(48.dp) + LayoutHeight.Max(48.dp)
    ) {
        PrimaryButton(
            text = text.takeIf { !isLoading } ?: "",
            modifier = modifier,
            shape = shape,
            isEnabled = isEnabled,
            onClick = onClick.takeIf { !isLoading }
        )

        if (isLoading) {
            Row(
                modifier = LayoutWidth.Fill + LayoutHeight.Fill,
                arrangement = Arrangement.Center
            ) {
                Column(
                    modifier = LayoutWidth.Min(40.dp) + LayoutHeight.Min(48.dp),
                    arrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = LayoutWidth.Max(40.dp) + LayoutHeight.Max(40.dp),
                        arrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(color = MaterialTheme.colors().onPrimary)
                    }
                }
            }
        }
    }
}
