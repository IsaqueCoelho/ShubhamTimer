package com.example.shubhamtimer.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shubhamtimer.ui.enums.TaskTimeEnum
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme

@Composable
fun TimerForm(
    timer: (String) -> Unit
) {
    var hour by remember { mutableStateOf("00") }
    var minute by remember { mutableStateOf("00") }
    var second by remember { mutableStateOf("00") }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        content = {
            items(
                items = TaskTimeEnum.values().toList(),
                itemContent = { item: TaskTimeEnum ->
                    TimerFormItem(
                        item = item,
                        itemTime = {
                            when (item) {
                                TaskTimeEnum.HOUR -> hour = if (it.isNotEmpty()) it else "00"
                                TaskTimeEnum.MINUTE -> minute = if (it.isNotEmpty()) it else "00"
                                TaskTimeEnum.SECOND -> second = if (it.isNotEmpty()) it else "00"
                            }
                        }
                    )
                })
        })

    timer("$hour:$minute:$second")
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
fun PreviewTimerForm() {
    ShubhamTimerTheme {
        TimerForm(
            timer = {}
        )
    }
}