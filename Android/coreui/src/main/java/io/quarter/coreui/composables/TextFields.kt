package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.PasswordTextField
import androidx.ui.core.Text
import androidx.ui.core.TextField
import androidx.ui.foundation.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.input.KeyboardType
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Row
import androidx.ui.layout.Stack
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun TextInput(
    hint: String,
    value: String,
    error: String? = null,
    identifier: String? = null,
    onImeAction: (ImeAction) -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onValueChange: (value: String) -> Unit
) {
    Column(modifier = LayoutPadding(bottom = 24.dp)) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            border = Border(
                size = 1.dp,
                color = MaterialTheme.colors().primary.takeIf {
                    error == null
                } ?: MaterialTheme.colors().error
            )
        ) {
            Column(
                modifier = LayoutHeight.Min(48.dp) + LayoutPadding(12.dp),
                arrangement = Arrangement.Center
            ) {
                Stack(modifier = LayoutWidth.Fill) {
                    if (value.isEmpty())
                        Text(
                            text = hint,
                            style = TextStyle(MaterialTheme.colors().secondary.copy(alpha = 0.6f))
                        )
                    TextField(
                        keyboardType = keyboardType,
                        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                        value = value,
                        onImeActionPerformed = onImeAction,
                        imeAction = imeAction,
                        onValueChange = onValueChange,
                        focusIdentifier = identifier
                    )
                }
            }
        }
        if (error != null) {
            Row(modifier = LayoutPadding(top = 4.dp, start = 8.dp)) {
                Text(
                    text = error, style = MaterialTheme.typography().caption.copy(
                        color = MaterialTheme.colors().error
                    )
                )
            }
        }
    }
}

@Composable
fun PasswordTextInput(
    hint: String,
    value: String,
    identifier: String? = null,
    layoutModifier: Modifier = LayoutPadding(bottom = 24.dp),
    imeAction: ImeAction = ImeAction.Done,
    onImeAction: (ImeAction) -> Unit = {},
    onValueChange: (value: String) -> Unit
) {
    Surface(
        modifier = layoutModifier,
        shape = RoundedCornerShape(8.dp),
        border = Border(1.dp, Color.Black)
    ) {
        Column(
            modifier = LayoutHeight.Min(48.dp) + LayoutPadding(12.dp),
            arrangement = Arrangement.Center
        ) {
            Stack(modifier = LayoutWidth.Fill) {
                if (value.isEmpty())
                    Text(
                        text = hint,
                        style = TextStyle(MaterialTheme.colors().secondary.copy(alpha = 0.6f))
                    )
                PasswordTextField(
                    focusIdentifier = identifier,
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                    value = value,
                    imeAction = imeAction,
                    onImeActionPerformed = onImeAction,
                    onValueChange = onValueChange
                )
            }
        }
    }
}
