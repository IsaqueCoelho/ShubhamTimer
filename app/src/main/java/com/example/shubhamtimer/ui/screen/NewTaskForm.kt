package com.example.shubhamtimer.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shubhamtimer.R
import com.example.shubhamtimer.ui.component.ComponentButton
import com.example.shubhamtimer.ui.component.TaskForm
import com.example.shubhamtimer.ui.component.TaskTypeList
import com.example.shubhamtimer.ui.component.TimerForm
import com.example.shubhamtimer.ui.enums.TaskTypeEnum
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme

@Composable
fun NewTaskForm(
    navigateUp: () -> Unit
) {

    var rememberTaskDescriptionForm by remember { mutableStateOf(Pair("", "")) }
    var rememberTaskType by remember { mutableStateOf(TaskTypeEnum.PRIORITY) }

    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        content = {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(id = R.string.new_task_title),
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold,
                )
                TaskForm(taskDescriptionForm = {
                    rememberTaskDescriptionForm = it
                })
                Spacer(modifier = Modifier.height(64.dp))
                TimerForm()
                Spacer(modifier = Modifier.height(32.dp))
                TaskTypeList(selectedTaskType = {
                    rememberTaskType = it
                })
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                ComponentButton(
                    text = stringResource(id = R.string.new_task_button),
                    onClickAction = { navigateUp() }
                )
            }
        }
    )
}

@Preview(
    name = "Full Content",
    showBackground = true
)
@Preview(
    name = "Full Content Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewMainContent() {
    ShubhamTimerTheme {
        NewTaskForm(
            navigateUp = {}
        )
    }
}