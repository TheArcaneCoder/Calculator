package com.thearcanecoder.calculator

import android.util.Log
import java.util.*

/**
 * This class evaluates a given expression
 * @author Bilal Naeem
 */
class ExpressionEvaluator {
    companion object {
        private const val TAG = "EXPRESSION_EVALUATOR"

        private var mExpressionEvaluator: ExpressionEvaluator? = null

        /**
         * Retrieve the instance of the ExpressionEvaluator class
         * @return The instance of the ExpressionEvaluator class
         */
        fun getInstance(): ExpressionEvaluator {
            if (mExpressionEvaluator == null) {
                mExpressionEvaluator = ExpressionEvaluator()
            }

            return mExpressionEvaluator!!
        }
    }

    /**
     * Evaluates the given expression
     * @param  expression The expression to evaluate
     * @return            The result of the expression
     */
    fun evaluate(expression: String): String {
        Log.i(TAG, "Evaluating $expression")

        val operands: Stack<String> = Stack()
        val operators: Stack<String> = Stack()

        val numberBuffer: StringBuffer = StringBuffer()

        expression.forEach {
            if (it in '0'..'9' || it == '.') {
                numberBuffer.append(it)
            } else if (it == '+' || it == '-' || it == '*' || it == '/') {
                if (!numberBuffer.isEmpty()) {
                    operands.push(numberBuffer.toString())
                    numberBuffer.delete(0, numberBuffer.length)
                }

                if (operators.isEmpty()) {
                    operators.push(it.toString())
                } else if (hasGreaterPrecedence(operators.peek(), it.toString())) {
                    operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()))
                    operators.push(it.toString())
                } else {
                    operators.push(it.toString())
                }
            } else if (it == '%') {
                if (!numberBuffer.isEmpty()) {
                    operands.push(numberBuffer.toString())
                    numberBuffer.delete(0, numberBuffer.length)
                }

                operands.push(applyOperator("/", "100", operands.pop()))
            } else if (it == '(') {
                if (!numberBuffer.isEmpty()) {
                    operands.push(numberBuffer.toString())
                    numberBuffer.delete(0, numberBuffer.length)
                }

                operators.push(it.toString())
            } else if (it == ')') {
                if (!numberBuffer.isEmpty()) {
                    operands.push(numberBuffer.toString())
                    numberBuffer.delete(0, numberBuffer.length)
                }

                while (true) {
                    val operator: String = operators.pop()
                    if (operator == "(") {
                        break
                    }

                    operands.push(applyOperator(operator, operands.pop(), operands.pop()))
                }
            }
        }

        if (!numberBuffer.isEmpty()) {
            operands.push(numberBuffer.toString())
        }

        while (!operators.isEmpty()) {
            val operator: String = operators.pop()

            if (operator == "(") { continue }
            operands.push(applyOperator(operator, operands.pop(), operands.pop()))
        }

        return if (operands.isEmpty()) {
            ""
        } else {
            operands.pop()
        }
    }

    /**
     * Checks whether an operator has greater precedence than another operator
     * @param  operator1 The first operator
     * @param  operator2 The second operator
     * @return           true if the first operator has greater precedence than the second operator
     */
    private fun hasGreaterPrecedence(operator1: String, operator2: String): Boolean {
        Log.i(TAG, "Checking if $operator1 has greater precedence than $operator2")

        return if ((operator1 == "*" || operator1 == "/") && (operator2 == "+" || operator2 == "-")) {
            true
        } else if ((operator1 == "+" || operator1 == "-") && (operator2 == "*" || operator2 == "/")) {
            false
        } else {
            false
        }
    }

    /**
     * Applies the given operator to the two given operands
     * @param  operator The operator to apply
     * @param  operand1 The first operand
     * @param  operand2 The second operand
     * @return          The result of applying the operator to the first and second operand
     */
    private fun applyOperator(operator: String, operand2: String, operand1: String): String {
        Log.i(TAG, "Applying $operator to $operand1 and $operand2")

        return when (operator) {
            "+" -> (operand1.toDouble() + operand2.toDouble()).toString()
            "-" -> (operand1.toDouble() - operand2.toDouble()).toString()
            "*" -> (operand1.toDouble() * operand2.toDouble()).toString()
            "/" -> (operand1.toDouble() / operand2.toDouble()).toString()
            else -> "0.0"
        }
    }
}