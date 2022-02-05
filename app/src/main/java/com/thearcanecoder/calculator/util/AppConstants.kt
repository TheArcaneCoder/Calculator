package com.thearcanecoder.calculator.util

import com.thearcanecoder.calculator.data.enums.ButtonType
import com.thearcanecoder.calculator.data.models.CalculatorButton

object AppConstants {
    val calculatorButtons: List<CalculatorButton> = listOf(
        CalculatorButton("CE", "", ButtonType.CLEAR),
        CalculatorButton("\u0028", "(", ButtonType.OPEN_PARENTHESIS), //Open parenthesis
        CalculatorButton("\u0029", ")", ButtonType.CLOSE_PARENTHESIS), //Close parenthesis
        CalculatorButton("\u0025", "%", ButtonType.OPERATOR), //Percentage
        CalculatorButton("7", "7", ButtonType.NUMBER),
        CalculatorButton("8", "8", ButtonType.NUMBER),
        CalculatorButton("9", "9", ButtonType.NUMBER),
        CalculatorButton("\u00F7", "/", ButtonType.OPERATOR), //Division
        CalculatorButton("4", "4", ButtonType.NUMBER),
        CalculatorButton("5", "5", ButtonType.NUMBER),
        CalculatorButton("6", "6", ButtonType.NUMBER),
        CalculatorButton("\u00D7", "*", ButtonType.OPERATOR), //Multiplication
        CalculatorButton("1", "1", ButtonType.NUMBER),
        CalculatorButton("2", "2", ButtonType.NUMBER),
        CalculatorButton("3", "3", ButtonType.NUMBER),
        CalculatorButton("\u002B", "+", ButtonType.OPERATOR), //Addition
        CalculatorButton(".", ".", ButtonType.DECIMAL),
        CalculatorButton("0", "0", ButtonType.NUMBER),
        CalculatorButton("=", "", ButtonType.EVALUATE),
        CalculatorButton("\u002D", "-", ButtonType.OPERATOR) // Subtraction
    )

    val NUMBERS: List<String> = listOf(
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."
    )

    val OPERATORS: List<String> = listOf(
        "%", "/", "*", "+", "-"
    )
}