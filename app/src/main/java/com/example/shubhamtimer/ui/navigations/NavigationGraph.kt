package com.example.shubhamtimer.ui.navigations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shubhamtimer.ui.screen.NewTaskForm
import com.example.shubhamtimer.ui.screen.TimerDisplay

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "new_task"
    ) {
        composable(route = "new_task") {
            NewTaskForm(
                navigateUp = {
                    navController.navigate("time_display")
                }
            )
        }
        composable(route = "time_display") {
            TimerDisplay(
                onBackPress = { navController.navigate("new_task") }
            )
        }
        /*composable(route = Screen.NewTask.route){ backStackEntry ->
            val groupName = backStackEntry.arguments?.getString("group_name")
            requireNotNull(groupName) { "Group Name parameter wasn't found. Please make sure it's set!" }
            NewTaskStackContent(navController = navController, groupName)
        }
        composable(route = Screen.Group.route){ backStackEntry ->
            val groupId = backStackEntry.arguments?.getString("group_id")
            requireNotNull(groupId) { "Group Name parameter wasn't found. Please make sure it's set!" }
            GroupTaskStackContent(navController = navController, groupId)
        }*/
    }
}