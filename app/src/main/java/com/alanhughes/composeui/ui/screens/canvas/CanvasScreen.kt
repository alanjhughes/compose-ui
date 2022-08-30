package com.alanhughes.composeui.ui.screens.canvas

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alanhughes.composeui.ui.components.canvas.Toggle
import com.alanhughes.composeui.ui.theme.ComposeUITheme

@Composable
fun CanvasScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            text = "Toggle",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp
        )
        Toggle(modifier = Modifier.fillMaxWidth(.7f))
    }
}

@Preview(showBackground = true)
@Composable
fun CanvasScreen_Preview() {
    ComposeUITheme {
        CanvasScreen()
    }
}
