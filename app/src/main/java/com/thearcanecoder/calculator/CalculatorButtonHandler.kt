package com.thearcanecoder.calculator

import android.util.Log

/**
 * Handles how each button should be handled based on the current input
 * @author Bilal Naeem
 */
class CalculatorButtonHandler {
    companion object {
        private const val TAG = "BUTTON_HANDLER"


        private val mExpressionEvaluator: ExpressionEvaluator = ExpressionEvaluator.getInstance()

        /**
         * Returns the String after appending the current button
         * @param  currentInput  The current value of the input field
         * @param  buttonPressed The value of the button that is pressed
         * @return               The resultant string
         */
        fun getStringToAdd(currentInput: String, buttonPressed: String): String {
            Log.i(TAG, "Checking if $buttonPressed can be added to $currentInput")

            val lastNumber: String = CalculatorInputUtils.getLastNumber(currentInput)
            val lastCharacter: String = CalculatorInputUtils.getLastCharacter(currentInput)

            return when {
                //Handles the case when zero is pressed
                CalculatorInputUtils.isZeroDigit(buttonPressed) -> {
                    if (CalculatorInputUtils.isOperator(lastCharacter) || lastNumber != "0") {
                        "${currentInput}0"
                    } else {
                        currentInput
                    }
                }
                //Handles the case when any non-zero digit is pressed
                CalculatorInputUtils.isNonZeroDigit(buttonPressed) -> {
                    if (lastNumber == "0") {
                        "${currentInput.substring(0, currentInput.length - 1)}$buttonPressed"
                    } else {
                        "$currentInput$buttonPressed"
                    }
                }
                //Handles the case when any operator is pressed
                CalculatorInputUtils.isOperator(buttonPressed) -> {
                    if (CalculatorInputUtils.isOperator(lastCharacter)) {
                        currentInput
                    } else if (CalculatorInputUtils.isOpenBracket(lastCharacter)) {
                        currentInput
                    } else if (CalculatorInputUtils.isDecimal(lastCharacter)) {
                        "${currentInput}0$buttonPressed"
                    } else {
                        "$currentInput$buttonPressed"
                    }
                }
                //Handles the case when the decimal point is pressed
                CalculatorInputUtils.isDecimal(buttonPressed) -> {
                    if (CalculatorInputUtils.isDecimalNumber(lastNumber)) {
                        currentInput
                    } else if (CalculatorInputUtils.isOperator(lastCharacter) || currentInput.isEmpty()) {
                        "${currentInput}0."
                    } else {
                        "$currentInput."
                    }
                }
                //Handles the case when equal is pressed
                CalculatorInputUtils.isEqual(buttonPressed) -> {
                    mExpressionEvaluator.evaluate(currentInput)
                }
                //Handles the case when clear is pressed
                CalculatorInputUtils.isClear(buttonPressed) -> {
                    ""
                }
                //Handles the case when bracket is pressed
                CalculatorInputUtils.isBracket(buttonPressed) -> {
                    if (lastCharacter.isEmpty() || CalculatorInputUtils.isOperator(lastCharacter)) {
                        "$currentInput("
                    } else if (CalculatorInputUtils.isNumber(lastCharacter)){
                        if (CalculatorInputUtils.getOpenBracketCount(currentInput) >
                            CalculatorInputUtils.getCloseBracketCount(currentInput)) {
                            "$currentInput)"
                        } else {
                            "$currentInput*("
                        }
                    } else {
                        "$currentInput)"
                    }
                }
                else -> {
                    currentInput
                }
            }
        }
    }
}