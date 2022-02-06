package com.thearcanecoder.calculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thearcanecoder.calculator.data.enums.ButtonType
import com.thearcanecoder.calculator.data.enums.InputType
import com.thearcanecoder.calculator.data.models.CalculatorButton
import com.thearcanecoder.calculator.data.models.InputPart
import com.thearcanecoder.calculator.util.InputHelper
import org.mariuszgromada.math.mxparser.Expression

class CalculatorViewModel : ViewModel() {
    private var input: ArrayList<InputPart> = ArrayList()
    private val _currentInput: MutableLiveData<String> = MutableLiveData("")
    val currentInput: LiveData<String> = _currentInput

    private val history: ArrayList<ArrayList<InputPart>> = ArrayList()
    private val _inputHistory: MutableLiveData<List<String>> = MutableLiveData(ArrayList())
    val inputHistory: LiveData<List<String>> = _inputHistory

    fun handleInput(button: CalculatorButton) {
        when (button.type) {
            ButtonType.NUMBER -> {
                if (input.isEmpty()) {
                    input.add(InputPart(button.value, button.internalValue, InputType.NUMBER))
                } else if (input.last().isNumber()) {
                    input.last().value += button.value
                } else {
                    if (input.last().isCloseParenthesis()) {
                        input.add(InputPart(button.value, button.internalValue, InputType.OPERATOR))
                    }
                    input.add(InputPart(button.value, button.internalValue, InputType.NUMBER))
                }
            }
            ButtonType.DECIMAL -> {
                if (input.isEmpty() || input.last().isOperator() || input.last().isOpenParenthesis()) {
                    input.add(InputPart("0.", "0.", InputType.NUMBER))
                } else if (input.last().isNumber() && input.last().value.contains(".").not()) {
                    input.last().value += "."
                }
            }
            ButtonType.OPERATOR -> {
                if (input.isEmpty().not()) {
                    if (input.last().isNumber() || input.last().isCloseParenthesis()) {
                        input.add(InputPart(button.value, button.internalValue, InputType.OPERATOR))
                    }
                }
            }
            ButtonType.OPEN_PARENTHESIS -> {
                if (input.isEmpty().not() && input.last().isNumber()) {
                    input.add(InputPart("\u00D7", "*", InputType.OPERATOR))
                }
                input.add(InputPart(button.value, button.internalValue, InputType.OPEN_PARENTHESIS))
            }
            ButtonType.CLOSE_PARENTHESIS -> {
                if (input.isEmpty().not()) {
                    if (input.count { it.isOpenParenthesis() } > input.count { it.isCloseParenthesis() }) {
                        input.add(InputPart(button.value, button.internalValue, InputType.CLOSE_PARENTHESIS))
                    }
                }
            }
            ButtonType.CLEAR -> {
                input.clear()
            }
            ButtonType.EVALUATE -> {
                if (input.isNotEmpty()) {
                    history.add(input)
                    _inputHistory.value = history.map { historyItem ->
                        historyItem.joinToString("") { it.value }
                    }

                    val result: Double = Expression(InputHelper.getValidInput(input)).calculate()
                    input.clear()
                    input.add(InputPart(result.toString(), result.toString(), InputType.NUMBER))
                }
            }
        }

        _currentInput.value = input.joinToString("") { it.value }
    }

    fun loadPreviousInput(index: Int) {
        input = history[index]
        _currentInput.value = input.joinToString("") { it.value }
    }
}