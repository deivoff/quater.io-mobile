package io.quarter.coreui.composables

import androidx.compose.Composable
import androidx.compose.getValue
import androidx.compose.setValue
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Border
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.TextField
import androidx.ui.foundation.TextFieldValue
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.input.KeyboardType
import androidx.ui.input.PasswordVisualTransformation
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.ColumnScope.gravity
import androidx.ui.layout.Row
import androidx.ui.layout.Stack
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.layout.preferredHeightIn
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ShowChart
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun TextInput(
  hint: String,
  value: TextFieldValue,
  error: String? = null,
  identifier: String? = null,
  onImeAction: (ImeAction) -> Unit = {},
  keyboardType: KeyboardType = KeyboardType.Text,
  imeAction: ImeAction = ImeAction.Next,
  onValueChange: (value: TextFieldValue) -> Unit
) {
  Column(modifier = Modifier.padding(bottom = 24.dp).fillMaxWidth()) {
    Surface(
      shape = RoundedCornerShape(8.dp),
      border = Border(
        size = 1.dp,
        color = MaterialTheme.colors.primary.takeIf {
          error == null
        } ?: MaterialTheme.colors.error
      )
    ) {
      Column(
        modifier = Modifier.preferredHeightIn(minHeight = 48.dp).padding(12.dp),
        verticalArrangement = Arrangement.Center
      ) {
        Stack(modifier = Modifier.fillMaxWidth()) {
          if (value.text.isEmpty())
            Text(
              text = hint,
              style = TextStyle(MaterialTheme.colors.secondary.copy(alpha = 0.6f))
            )
          TextField(
            focusIdentifier = identifier,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = keyboardType,
            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
            value = value,
            onImeActionPerformed = onImeAction,
            imeAction = imeAction,
            onValueChange = onValueChange
          )
        }
      }
    }
    if (error != null) {
      Row(modifier = Modifier.padding(start = 8.dp, top = 4.dp)) {
        Text(
          text = error, style = MaterialTheme.typography.caption.copy(
            color = MaterialTheme.colors.error
          )
        )
      }
    }
  }
}

@Composable
fun PasswordTextInput(
  hint: String,
  value: TextFieldValue,
  identifier: String? = null,
  layoutModifier: Modifier = Modifier.padding(bottom = 24.dp),
  imeAction: ImeAction = ImeAction.Done,
  onImeAction: (ImeAction) -> Unit = {},
  onValueChange: (value: TextFieldValue) -> Unit
) {
  Surface(
    modifier = layoutModifier,
    shape = RoundedCornerShape(8.dp),
    border = Border(1.dp, Color.Black)
  ) {
    Column(
      modifier = Modifier.preferredHeightIn(minHeight = 48.dp) + Modifier.padding(12.dp),
      verticalArrangement = Arrangement.Center
    ) {
      Stack(modifier = Modifier.fillMaxWidth()) {
        if (value.text.isEmpty())
          Text(
            text = hint,
            style = TextStyle(MaterialTheme.colors.secondary.copy(alpha = 0.6f))
          )
        TextField(
          modifier = Modifier.fillMaxWidth(),
          keyboardType = KeyboardType.Password,
          focusIdentifier = identifier,
          textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
          value = value,
          imeAction = imeAction,
          onImeActionPerformed = onImeAction,
          onValueChange = onValueChange,
          visualTransformation = PasswordVisualTransformation()
        )
      }
    }
  }
}
