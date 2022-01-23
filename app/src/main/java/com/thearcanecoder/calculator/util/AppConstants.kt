package com.thearcanecoder.calculator.util

import com.thearcanecoder.calculator.data.CalculatorButton
import com.thearcanecoder.calculator.data.enum.ButtonType

object AppConstants {
    val calculatorButtons: List<CalculatorButton> = listOf(
        CalculatorButton("CE", ButtonType.CLEAR),
        CalculatorButton("\u0028", ButtonType.PARENTHESIS), //Left parenthesis
        CalculatorButton("\u0029", ButtonType.PARENTHESIS), //Right parenthesis
        CalculatorButton("\u0025", ButtonType.OPERATOR), //Percentage
        CalculatorButton("7", ButtonType.NUMBER),
        CalculatorButton("8", ButtonType.NUMBER),
        CalculatorButton("9", ButtonType.NUMBER),
        CalculatorButton("\u00F7", ButtonType.OPERATOR), //Division
        CalculatorButton("4", ButtonType.NUMBER),
        CalculatorButton("5", ButtonType.NUMBER),
        CalculatorButton("6", ButtonType.NUMBER),
        CalculatorButton("\u00D7", ButtonType.OPERATOR), //Multiplication
        CalculatorButton("1", ButtonType.NUMBER),
        CalculatorButton("2", ButtonType.NUMBER),
        CalculatorButton("3", ButtonType.NUMBER),
        CalculatorButton("\u002B", ButtonType.OPERATOR), //Addition
        CalculatorButton(".", ButtonType.DECIMAL),
        CalculatorButton("0", ButtonType.NUMBER),
        CalculatorButton("=", ButtonType.EVALUATE),
        CalculatorButton("\u002D", ButtonType.OPERATOR) // Subtraction
    )
}