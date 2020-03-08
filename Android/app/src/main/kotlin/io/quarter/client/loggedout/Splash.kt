package io.quarter.client.loggedout

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Spacer
import androidx.ui.material.MaterialTheme
import androidx.ui.text.style.TextAlign
import androidx.ui.unit.dp
import dev.steelahhh.coreui.composables.PrimaryButton
import io.quarter.core.Strings

/*
 * Author: steelahhh
 * 9/3/20
 */

interface Splash {
    companion object {
        @Composable
        fun Content(

            loginClick: () -> Unit,
            registerClick: () -> Unit
        ) {
            Column(
                modifier = LayoutPadding(16.dp),
                arrangement = Arrangement.Center
            ) {
                Text(
                    modifier = LayoutWidth.Fill,
                    text = "quarter.io",
                    style = MaterialTheme.typography().h2.copy(
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = LayoutHeight.Min(92.dp))
                PrimaryButton(text = Strings.Authorization.login, onClick = loginClick)
                Spacer(modifier = LayoutHeight.Min(16.dp))
                PrimaryButton(text = Strings.Authorization.register, onClick = registerClick)
            }
        }
    }
}
