package com.example.shubhamtimer.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.shubhamtimer.R
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme

@Composable
fun TimerDisplayButtons(
    onStartClick: () -> Unit,
    onCancelClick: () -> Unit,
    onPauseClick: () -> Unit
) {

    var displayGroup by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        when {
            displayGroup -> {
                ComponentButton(
                    text = stringResource(id = R.string.timer_display_button_cancel),
                    buttonColor = MaterialTheme.colors.secondary,
                    onClickAction = {
                        displayGroup = false
                        onCancelClick()
                    }
                )
                ComponentButton(
                    text = stringResource(id = R.string.timer_display_button_pause),
                    buttonColor = MaterialTheme.colors.secondaryVariant,
                    onClickAction = {
                        onPauseClick()
                    }
                )
            }
            else -> {
                ComponentButton(
                    text = stringResource(id = R.string.timer_display_button_start),
                    buttonColor = MaterialTheme.colors.secondary,
                    onClickAction = {
                        displayGroup = true
                        onStartClick()
                    }
                )
            }

        }
    }
}

@Preview(
    name = "timer diplay buttons - Light mode",
    showBackground = true
)
@Preview(
    name = "timer diplay buttons - Light mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewTimerDisplayButtons() {
    ShubhamTimerTheme {
        TimerDisplayButtons(
            onStartClick = {},
            onCancelClick = {},
            onPauseClick = {}
        )
    }
}