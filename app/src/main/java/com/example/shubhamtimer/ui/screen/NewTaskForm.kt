package com.example.shubhamtimer.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shubhamtimer.R
import com.example.shubhamtimer.ui.component.ConfirmButton
import com.example.shubhamtimer.ui.component.TaskForm
import com.example.shubhamtimer.ui.component.TaskTypeList
import com.example.shubhamtimer.ui.component.TimerForm
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme

@Composable
fun NewTaskForm() {
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
                    text = "New Task",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold,
                )
                TaskForm()
                TaskTypeList()
                Spacer(modifier = Modifier.height(64.dp))
                TimerForm()
                ConfirmButton(
                    stringResource(id = R.string.new_task_button)
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
        NewTaskForm()
    }
}