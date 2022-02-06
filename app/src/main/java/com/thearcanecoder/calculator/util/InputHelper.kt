package com.thearcanecoder.calculator.util

import com.thearcanecoder.calculator.data.enums.InputType
import com.thearcanecoder.calculator.data.models.InputPart

/**
 * Get a valid input from the provided input list. This requires removing unnecessary operators and
 * parenthesis from the input
 */
object InputHelper {
    fun getValidInput(input: ArrayList<InputPart>): String {
        return if (input.none { it.isNumber() }) {
            "0"
        } else if (input.last().isOpenParenthesis()) {
            getValidInput(input.subList(0, input.size - 1) as ArrayList<InputPart>)
        } else if (input.last().isOperator() && input.last().value != "%") {
            getValidInput(input.subList(0, input.size - 1) as ArrayList<InputPart>)
        } else {
            val openParenthesisCount = input.count { it.isOpenParenthesis() }
            val closeParenthesisCount = input.count { it.isCloseParenthesis() }

            if (openParenthesisCount > closeParenthesisCount) {
                getValidInput(input.apply {
                    (0 until openParenthesisCount - closeParenthesisCount).forEach { _ ->
                        this.add(InputPart(")", ")", InputType.CLOSE_PARENTHESIS))
                    }
                })
            } else {
                input.joinToString("") { it.internalValue }
            }
        }
    }
}