package com.thearcanecoder.calculator.data.models

import com.thearcanecoder.calculator.data.enums.InputType

data class InputPart(
    var value: String,
    var internalValue: String,
    val type: InputType
) {
    fun isNumber(): Boolean {
        return type == InputType.NUMBER
    }

    fun isOperator(): Boolean {
        return type == InputType.OPERATOR
    }

    fun isOpenParenthesis(): Boolean {
        return type == InputType.OPEN_PARENTHESIS
    }

    fun isCloseParenthesis(): Boolean {
        return type == InputType.CLOSE_PARENTHESIS
    }

    fun isParenthesis(): Boolean {
        return isOpenParenthesis() || isCloseParenthesis()
    }
}
