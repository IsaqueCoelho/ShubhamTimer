package com.example.shubhamtimer.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class TimerDisplayViewModel(
    private val timerDisplaying: String
) : ViewModel() {

    private lateinit var countDownTimer: CountDownTimer
    var uiState by mutableStateOf(TimerDisplayState(timeToDisplay = timerDisplaying))

    fun startTime(timer: String = "00:00:00") {

        val timerInMilisec = getTimeInMilisec(timer)

        countDownTimer = object : CountDownTimer(timerInMilisec, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                uiState = TimerDisplayState(
                    timeToDisplay = getTimeToDisplay(currentTime = millisUntilFinished),
                    progressBar = (millisUntilFinished * 1f) / timerInMilisec,
                    counting = true
                )
            }

            override fun onFinish() {
                uiState = TimerDisplayState(
                    timeToDisplay = timerDisplaying,
                    progressBar = 1F,
                    counting = false
                )
            }

        }.start()
    }

    fun pauseTimer() {
        countDownTimer.cancel()
        uiState.counting = false
    }

    fun cancelTimer() {
        countDownTimer.cancel()
        uiState = TimerDisplayState(
            timeToDisplay = timerDisplaying,
            progressBar = 1f,
            counting = false
        )
    }

    private fun getTimeInMilisec(timer: String): Long {
        val localTime = LocalTime.parse(
            timer,
            DateTimeFormatter.ofPattern("HH:mm:ss")
        )

        return (localTime.second * 1000).toLong()

    }

    private fun getTimeToDisplay(currentTime: Long): String {

        val date =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(currentTime), ZoneId.systemDefault())

        return date.toLocalTime().toString()
    }
}