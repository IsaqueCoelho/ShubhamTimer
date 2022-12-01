package com.example.shubhamtimer.ui.navigations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.shubhamtimer.ui.enums.TaskTypeEnum
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
                navigateUp = { taskDescriptions, taskType, time ->
                    navController.navigate("time_display/${taskDescriptions.first}/${taskDescriptions.second}/${taskType.name}/$time")
                }
            )
        }
        composable(
            route = "time_display/{title}/{description}/{task_type}/{time}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("task_type") { type = NavType.StringType },
                navArgument("time") { type = NavType.StringType },
            )
        ) { backStackEntry ->

            val title = backStackEntry.arguments?.getString("title")
            requireNotNull(title) { "title Name parameter wasn't found. Please make sure it's set!" }
            val description = backStackEntry.arguments?.getString("description")
            requireNotNull(description) { "description Name parameter wasn't found. Please make sure it's set!" }
            val task_type = backStackEntry.arguments?.getString("task_type")
            requireNotNull(task_type) { "task_type Name parameter wasn't found. Please make sure it's set!" }
            val time = backStackEntry.arguments?.getString("time")
            requireNotNull(time) { "time Name parameter wasn't found. Please make sure it's set!" }

            TimerDisplay(
                taskDescription = Pair(title, description),
                taskeType = TaskTypeEnum.valueOf(task_type),
                time = time,
                onBackPress = { navController.navigate("new_task") }
            )
        }
    }
}