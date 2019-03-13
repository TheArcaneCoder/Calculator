package com.thearcanecoder.calculator

import android.util.Log

/**
 * Calculator Button Handler
 * @author Bilal Naeem
 */
class CalculatorUtils {
    companion object {
        private const val TAG = "BUTTON_HANDLER"

        /**
         * Returns the String which can be appended to the current input
         * @param  currentInput  The current value of the input field
         * @param  buttonPressed The value of the button that is pressed
         * @return               The String that can be added
         */
        fun getStringToAdd(currentInput: String, buttonPressed: String): String {
            Log.i(TAG, "Checking if $buttonPressed can be added to $currentInput")

            val lastCharacter: String = StringUtils.getLastCharacter(currentInput)

            when (buttonPressed) {
                "0" -> {
                    //TODO: Fix this condition
                    return if (lastCharacter == "0" && currentInput.length == 1) {
                        ""
                    } else {
                        "0"
                    }
                }
                "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                    return buttonPressed
                }
                "+", "-", "*", "/" -> {
                    return if (StringUtils.isDigit(lastCharacter)) {
                        buttonPressed
                    } else {
                        ""
                    }
                }
                else -> {
                    return ""
                }
            }
        }
    }
}