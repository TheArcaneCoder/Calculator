package com.thearcanecoder.calculator.listener

import com.thearcanecoder.calculator.data.CalculatorButton

interface CalculatorButtonClickListener {
    fun onButtonClick(button: CalculatorButton)
}