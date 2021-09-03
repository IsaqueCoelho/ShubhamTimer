package com.example.shubhamtimer

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shubhamtimer.ui.component.TaskForm
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShubhamTimerTheme {
                Scaffold(
                    backgroundColor = MaterialTheme.colors.background,
                    content = { MainContent() }
                )
            }
        }
    }
}

@Composable
fun MainContent() {
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
    }
}

@Preview(
    name = "Full Content",
    showBackground = true
)
@Preview(
    name = "Full Content Dark Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PreviewMainContent() {
    ShubhamTimerTheme {
        MainContent()
    }
}