package com.example.shubhamtimer.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shubhamtimer.ui.theme.GreenA500
import com.example.shubhamtimer.ui.theme.White


@Composable
fun ConfirmButton(
    text: String = ""
) {
    Column(
        modifier = Modifier
            .padding(bottom = 32.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { /* Do something! */ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults
                .textButtonColors(
                    backgroundColor = GreenA500
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
}