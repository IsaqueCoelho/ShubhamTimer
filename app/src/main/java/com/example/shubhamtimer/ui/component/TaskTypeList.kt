package com.example.shubhamtimer.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shubhamtimer.ui.enums.TaskTypeEnum
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme


@Composable
fun TaskTypeList(
    selectedTaskType: (taskType: TaskTypeEnum) -> Unit
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        var selectedItem by remember { mutableStateOf(TaskTypeEnum.PRIORITY) }

        Text(
            modifier = Modifier.padding(16.dp),
            text = "Task Type",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
        )
        LazyRow(
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(TaskTypeEnum.values().toList()) { item: TaskTypeEnum ->
                TaskTypeItem(
                    item = item,
                    isSelected = item == selectedItem,
                    performClick = {
                        selectedItem = it
                        selectedTaskType(it)
                    }
                )
            }
        }
    }
}

@Preview(
    name = "Light mode",
    showBackground = true
)
@Preview(
    name = "Dark mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PreviewTaskTypeList() {
    ShubhamTimerTheme {
        TaskTypeList(selectedTaskType = {})
    }
}