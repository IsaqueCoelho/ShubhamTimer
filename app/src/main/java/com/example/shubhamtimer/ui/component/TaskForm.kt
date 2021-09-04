package com.example.shubhamtimer.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shubhamtimer.R
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
        var taskNameValue by remember { mutableStateOf("") }
        var taskDescriptionValue by remember { mutableStateOf("") }

        TextField(
            value = taskNameValue,
            onValueChange = { taskNameValue = it },
            placeholder = { Text(text = stringResource(R.string.taskform_name)) },
            modifier = Modifier.fillMaxWidth(),
        )
        TextField(
            value = taskDescriptionValue,
            onValueChange = { taskDescriptionValue = it },
            placeholder = { Text(text = stringResource(R.string.taskform_description)) },
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