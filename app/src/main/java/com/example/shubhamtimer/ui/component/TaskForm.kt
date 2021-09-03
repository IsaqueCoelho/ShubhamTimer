package com.example.shubhamtimer.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme


@Composable
fun TaskForm() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colors.primaryVariant,
                shape = RoundedCornerShape(8.dp)
            ),
    ) {
        var taskNameValue by remember { mutableStateOf("Task Name") }
        var taskDescriptionValue by remember { mutableStateOf("Task Description") }

        TextField(
            value = taskNameValue,
            onValueChange = { taskNameValue = it },
            modifier = Modifier.fillMaxWidth(),
        )
        TextField(
            value = taskDescriptionValue,
            onValueChange = { taskDescriptionValue = it },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview(
    name = "Forms",
    showBackground = true
)
@Preview(
    name = "Forms Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewForms() {
    ShubhamTimerTheme {
        TaskForm()
    }
}