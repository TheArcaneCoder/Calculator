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

            val lastCharacter: String = CalculatorInputUtils.getLastCharacter(currentInput)

            return when {
                CalculatorInputUtils.isDigit(buttonPressed) -> {
                    if (buttonPressed == "0") {
                        if (currentInput.length == 1 && lastCharacter == "0") {
                            ""
                        } else if (CalculatorInputUtils.isOperator(lastCharacter) || CalculatorInputUtils.isNonZeroDigit(lastCharacter) ||
                            CalculatorInputUtils.extractNumbers(currentInput).last() != "0") {
                            "0"
                        } else {
                            ""
                        }
                    } else {
                        buttonPressed
                    }
                }
                CalculatorInputUtils.isOperator(buttonPressed) -> {
                    if (CalculatorInputUtils.isOperator(lastCharacter)) {
                        ""
                    }
                    else {
                        buttonPressed
                    }
                }
                else -> {
                    ""
                }
            }
        }
    }
}