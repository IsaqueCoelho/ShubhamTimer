package com.example.shubhamtimer.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.shubhamtimer.ui.theme.GreenA500
import com.example.shubhamtimer.ui.theme.White


@Composable
fun ComponentButton(
    text: String = "",
    buttonColor: Color = GreenA500,
    onClickAction: () -> Unit
) {
    Button(
        onClick = { onClickAction() },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults
            .textButtonColors(
                backgroundColor = buttonColor
            ),
        content = {
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = text,
                color = White,
            )
        }
    )
}