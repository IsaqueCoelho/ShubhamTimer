package com.example.shubhamtimer.ui.mask

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class TimerMaskVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        // Making XX string.

        val lenght = text.text.length

        val trimmed = text.text
        var out = ""

        if (lenght == 1) {
            out += "0${trimmed[0]}"
        }

        if (lenght == 2) {
            out += trimmed
        }

        if (lenght > 2 && trimmed[0] == '0') {
            for (textCount in trimmed.indices){
                if (textCount > 0){
                    out += trimmed[textCount]
                }
            }
        }

        val timerOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {

//                if (offset == 1) return offset + 1
                if (offset == 2) return offset
                if (offset == 3) return offset - 1

                return offset
//
//                if (offset == 2) return offset
//                if (offset < 2) return offset + 1
//                return 2
            }

            override fun transformedToOriginal(offset: Int): Int {
//
//                if (offset == 2) return offset + 1
//                if (offset == 2) return offset
//                if (offset == 3) return offset - 1

                return offset
            }
        }

        return TransformedText(AnnotatedString(out), timerOffsetTranslator)
    }
}