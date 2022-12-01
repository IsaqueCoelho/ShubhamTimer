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
import com.example.shubhamtimer.ui.component.TaskTypeItem
import com.example.shubhamtimer.ui.component.TimerDisplayButtons
import com.example.shubhamtimer.ui.component.TimerDisplayComponent
import com.example.shubhamtimer.ui.enums.TaskTypeEnum
import com.example.shubhamtimer.ui.theme.Black
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme
import com.example.shubhamtimer.ui.theme.White


@Composable
fun TimerDisplay(
    taskDescription: Pair<String, String> = Pair("", ""),
    taskeType: TaskTypeEnum = TaskTypeEnum.PRIORITY,
    time: String = "00:00:00",
    onBackPress: () -> Unit
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
                        onClick = { onBackPress() }
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
                modifier = Modifier.padding(16.dp)
            ) {
                TaskTypeItem(
                    item = taskeType,
                    performClick = {}
                )
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(
                        text = taskDescription.first,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(text = taskDescription.second)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TimerDisplayComponent(
                    timer = time,
                    progress = 1f
                )
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
        TimerDisplay(
            taskDescription = Pair(
                "Title Loren Ipsum",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
            ),
            taskeType = TaskTypeEnum.WORK,
            time = "00:07:00",
            onBackPress = {}
        )
    }
}