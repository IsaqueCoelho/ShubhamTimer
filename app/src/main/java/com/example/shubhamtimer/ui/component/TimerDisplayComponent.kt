package com.example.shubhamtimer.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shubhamtimer.ui.theme.Black
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme
import com.example.shubhamtimer.ui.theme.White

@Composable
fun TimerDisplayComponent(
    progress: Float = 1f,
    timer: String = "00:00:00",
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                color = if (isSystemInDarkTheme()) White else Black,
                modifier = Modifier.size(350.dp),
                progress = progress,
                strokeWidth = 12.dp
            )
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = timer,
                    fontSize = 42.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h1,
                    color = if (isSystemInDarkTheme()) White else Black,
                )
            }
        }
    }
}


@Preview(
    name = "Timer Display - Component",
    showBackground = true
)
@Preview(
    name = "Timer Display - Component Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewTimerDisplayComponent() {
    ShubhamTimerTheme {
        TimerDisplayComponent()
    }
}