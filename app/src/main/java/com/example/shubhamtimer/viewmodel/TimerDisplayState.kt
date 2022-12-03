package com.example.shubhamtimer.viewmodel

data class TimerDisplayState(
    var timeToDisplay: String = "00:00:00",
    var progressBar: Float = 1f,
    var counting: Boolean = false
)
