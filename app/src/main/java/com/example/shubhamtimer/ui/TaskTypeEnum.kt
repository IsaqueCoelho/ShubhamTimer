package com.example.shubhamtimer.ui

import androidx.annotation.DrawableRes
import com.example.shubhamtimer.R

enum class TaskTypeEnum(
    @DrawableRes val icon: Int,
    val title: String
) {
    PRIORITY(
        icon = R.drawable.ic_star,
        title = "Priority"
    ),
    WORK(
        icon = R.drawable.ic_work,
        title = "Work"
    ),
    RELAX(
        icon = R.drawable.ic_gamepad,
        title = "Relax"
    ),
    FOOD(
        icon = R.drawable.ic_fork_knife,
        title = "Food"
    ),
}