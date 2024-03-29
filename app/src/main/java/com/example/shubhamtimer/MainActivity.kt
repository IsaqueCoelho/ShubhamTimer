package com.example.shubhamtimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import com.example.shubhamtimer.ui.navigations.NavigationGraph
import com.example.shubhamtimer.ui.screen.NewTaskForm
import com.example.shubhamtimer.ui.theme.ShubhamTimerTheme

@ExperimentalFoundationApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShubhamTimerTheme {
                NavigationGraph()
            }
        }
    }
}