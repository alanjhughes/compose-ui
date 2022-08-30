package com.alanhughes.composeui.ui.components.canvas

import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alanhughes.composeui.ui.theme.ComposeUITheme

enum class SelectionType {
    ONE,
    TWO
}

@Composable
fun Selector(modifier: Modifier = Modifier) {
    var selectionState by remember {
        mutableStateOf(SelectionType.ONE)
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(text = "Options: ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Box(
            modifier = Modifier
                .background(Color.LightGray, shape = RoundedCornerShape(15.dp))
                .requiredHeight(50.dp)
                .padding(5.dp),
        ) {
            Highlight(
                selectionState = selectionState
            )
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectionState = SelectionType.ONE },
                    text = "Eat In",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectionState = SelectionType.TWO },
                    text = "Take Away",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun Highlight(modifier: Modifier = Modifier, selectionState: SelectionType) =
    BoxWithConstraints {
        val offset by animateOffsetAsState(
            targetValue = if (selectionState == SelectionType.ONE) Offset.Zero else Offset(
                maxWidth.value / 2,
                0f
            )
        )
        Box(
            modifier = modifier
                .width(maxWidth / 2)
                .fillMaxHeight()
                .offset(offset.x.dp, offset.y.dp)
                .background(Color.Blue, shape = RoundedCornerShape(10.dp))
        )
    }

@Preview(showBackground = true)
@Composable
fun Selector_Preview() {
    ComposeUITheme {
        Selector()
    }
}