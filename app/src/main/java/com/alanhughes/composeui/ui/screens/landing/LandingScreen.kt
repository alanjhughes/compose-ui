package com.alanhughes.composeui.ui.screens.landing

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alanhughes.composeui.navigation.Screen

data class ScreenRoute(
    val title: String,
    val screen: Screen,
)

val destinations = listOf(
    ScreenRoute(title = "Canvas", screen = Screen.CanvasScreen)
)

@Composable
fun LandingScreen(navigate: (String) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            text = "Available Destinations",
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(10.dp)) {
            items(destinations) { destination ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clickable {
                            navigate(destination.screen.route)
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = destination.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = Icons.Filled.NavigateNext,
                        contentDescription = "Navigate arrow",
                        tint = Color.DarkGray
                    )
                }
            }
        }
    }
}