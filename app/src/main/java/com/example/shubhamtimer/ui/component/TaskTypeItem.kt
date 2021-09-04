package com.example.shubhamtimer.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shubhamtimer.ui.TaskTypeEnum
import com.example.shubhamtimer.ui.theme.*

@Composable
fun TaskTypeItem(
    item: TaskTypeEnum = TaskTypeEnum.PRIORITY
) {
    var isSelected by remember { mutableStateOf(false) }

    val iconBackground: Color by animateColorAsState(
        if (isSelected) MaterialTheme.colors.secondaryVariant else Color.Transparent,
    )

    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                isSelected = !isSelected
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = null,
            tint = setIconColor(
                isSelected = isSelected,
                isDarkMode = isSystemInDarkTheme()
            ),
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(iconBackground),
        )
        Text(
            text = item.title,
            color = setIconTitleColor(
                isSelected = isSelected,
                isDarkMode = isSystemInDarkTheme()
            ),
        )
    }
}

fun setIconColor(isSelected: Boolean, isDarkMode: Boolean): Color {
    return when {
        isSelected || isDarkMode -> {
            White
        }
        else -> {
            Black
        }
    }
}

fun setIconTitleColor(isSelected: Boolean, isDarkMode: Boolean): Color {
    return when {
        isSelected && isDarkMode -> {
            GreenA700
        }
        isSelected -> {
            GreenA500
        }
        isDarkMode -> {
            White
        }
        else -> {
            Black
        }
    }
}

@Preview(
    name = "Default",
    showBackground = true
)
@Preview(
    name = "Default DarkMode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PreviewIconItem() {
    ShubhamTimerTheme {
        TaskTypeItem()
    }
}