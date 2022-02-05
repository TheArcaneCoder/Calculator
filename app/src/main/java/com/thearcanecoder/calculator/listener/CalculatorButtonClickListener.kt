package com.thearcanecoder.calculator.listener

import com.thearcanecoder.calculator.data.models.CalculatorButton

interface CalculatorButtonClickListener {
    fun onButtonClick(button: CalculatorButton)
}