package com.example.shubhamtimer.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shubhamtimer.R
import com.example.shubhamtimer.ui.component.TimerDisplayButtons
import com.example.shubhamtimer.ui.component.TimerDisplayComponent
import com.example.shubhamtimer.ui.enums.TaskTypeEnum
import com.example.shubhamtimer.ui.theme.Black
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme
import com.example.shubhamtimer.ui.theme.White


@Composable
fun TimerDisplay(
    taskeTypeEnum: TaskTypeEnum = TaskTypeEnum.PRIORITY,
    timeInSeconds: Int = 0
) {

    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row {
                    IconButton(
                        content = {
                            Icon(
                                modifier = Modifier
                                    .size(36.dp),
                                imageVector = Icons.Rounded.ArrowBack,
                                contentDescription = "Botão voltar",
                                tint = if (isSystemInDarkTheme()) White else Black,
                            )
                        },
                        onClick = { /*TODO*/ }
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = stringResource(id = R.string.timer_display_title),
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        },
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TimerDisplayComponent(
                    timer = "00:00:00",
                    progress = 1f
                )
                Text(text = "alow")
            }
        },
        bottomBar = {
            Column(modifier = Modifier.padding(16.dp)) {
                TimerDisplayButtons(
                    onStartClick = {},
                    onCancelClick = {},
                    onPauseClick = {}
                )
            }
        }
    )
}

@Preview(
    name = "Timer Display - Full Content",
    showBackground = true
)
@Preview(
    name = "Timer Display - Full Content Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewTimerDisplay() {
    ShubhamTimerTheme {
        TimerDisplay()
    }
}