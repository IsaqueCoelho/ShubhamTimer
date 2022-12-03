package com.example.shubhamtimer.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shubhamtimer.ui.enums.TaskTimeEnum
import com.example.shubhamtimer.ui.mask.TimerMaskVisualTransformation
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme

@Composable
fun TimerFormItem(
    item: TaskTimeEnum = TaskTimeEnum.HOUR,
    itemTime: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var taskTimerValue by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .width(71.dp)
                .background(MaterialTheme.colors.background),
            value = taskTimerValue,
            onValueChange = {
                taskTimerValue = it
            },
            textStyle = MaterialTheme.typography.h4,
            singleLine = true,
            shape = MaterialTheme.shapes.small,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = {
                Text(
                    text = "00",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold,
                )
            },
            visualTransformation = TimerMaskVisualTransformation(item)
        )

        Text(
            text = item.title,
        )
        itemTime(taskTimerValue)
    }
}

@Preview(
    name = "Light mode",
    showBackground = true
)
@Preview(
    name = "Dark mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewTimerFormItem() {
    ShubhamTimerTheme {
        TimerFormItem(
            itemTime = {}
        )
    }
}