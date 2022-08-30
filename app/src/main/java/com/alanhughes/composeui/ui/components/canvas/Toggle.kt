package com.alanhughes.composeui.ui.components.canvas

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alanhughes.composeui.ui.theme.ComposeUITheme
import com.alanhughes.composeui.ui.theme.LightGray
import com.alanhughes.composeui.ui.theme.MediumGray

enum class ToggleState(val title: String) {
    ONE("One"),
    TWO("Two")
}

@Composable
fun Toggle(modifier: Modifier = Modifier) {
    var toggleState by remember {
        mutableStateOf(ToggleState.ONE)
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "Options: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Box(
            modifier = Modifier
                .background(LightGray, shape = RoundedCornerShape(15.dp))
                .border(1.dp, color = MediumGray, shape = RoundedCornerShape(15.dp))
                .requiredHeight(50.dp)
                .padding(5.dp),
        ) {
            Highlight(
                toggleState = toggleState
            )
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SelectionTab(
                    modifier = Modifier
                        .weight(1f),
                    currentState = toggleState,
                    targetState = ToggleState.ONE
                ) {
                    toggleState = it
                }

                SelectionTab(
                    modifier = Modifier
                        .weight(1f),
                    currentState = toggleState,
                    targetState = ToggleState.TWO
                ) {
                    toggleState = it
                }
            }
        }
    }
}

@Composable
fun Highlight(modifier: Modifier = Modifier, toggleState: ToggleState) =
    BoxWithConstraints {
        val offset by animateOffsetAsState(
            targetValue = if (toggleState == ToggleState.ONE) Offset.Zero else Offset(
                maxWidth.value / 2,
                0f
            ),
            animationSpec = tween(500, 0, FastOutSlowInEasing)
        )

        Box(
            modifier = modifier
                .width(maxWidth / 2)
                .fillMaxHeight()
                .offset(offset.x.dp, offset.y.dp)
                .background(MaterialTheme.colors.primaryVariant, shape = RoundedCornerShape(10.dp))
        )
    }

@Composable
fun SelectionTab(
    modifier: Modifier = Modifier,
    currentState: ToggleState,
    targetState: ToggleState,
    setToggleState: (ToggleState) -> Unit
) {
    val color by animateColorAsState(targetValue = if (currentState == targetState) Color.White else Color.Black)

    TextButton(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        onClick = { setToggleState(targetState) }) {
        Text(
            text = targetState.title,
            color = color,
            fontSize = 18.sp,
            fontWeight = if (currentState == targetState) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Preview(showBackground = true, name = "Toggle")
@Composable
fun Toggle_Preview() {
    ComposeUITheme {
        Toggle()
    }
}