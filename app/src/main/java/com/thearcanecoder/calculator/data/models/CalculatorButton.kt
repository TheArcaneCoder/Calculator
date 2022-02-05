package com.thearcanecoder.calculator.data.models

import com.thearcanecoder.calculator.data.enums.ButtonType

data class CalculatorButton(
    val value: String,
    val internalValue: String,
    val type: ButtonType
)
