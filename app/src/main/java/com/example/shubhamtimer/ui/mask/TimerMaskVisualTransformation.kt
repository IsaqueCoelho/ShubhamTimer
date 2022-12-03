package com.example.shubhamtimer.ui.mask

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import com.example.shubhamtimer.ui.enums.TaskTimeEnum

class TimerMaskVisualTransformation(private val item: TaskTimeEnum) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {

        val parsedText = if (text.text.isEmpty()) 0 else text.text.toInt()

        val finalText = when (item) {
            TaskTimeEnum.HOUR -> {
                if (parsedText > 23) "00" else text.text
            }
            TaskTimeEnum.MINUTE,
            TaskTimeEnum.SECOND -> {
                if (parsedText > 59) "00" else text.text
            }
        }

        val timeOffsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int = offset

            override fun transformedToOriginal(offset: Int): Int = offset

        }

        return TransformedText(
            AnnotatedString(finalText),
            timeOffsetMapping
        )
    }

}