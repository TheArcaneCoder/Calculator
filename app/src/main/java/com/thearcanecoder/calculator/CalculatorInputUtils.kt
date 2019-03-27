package com.thearcanecoder.calculator

import android.util.Log

/**
 * Calculator input utility class
 * @author Bilal Naeem
 */
class CalculatorInputUtils {
    companion object {
        private const val TAG = "STRING_UTILS"

        /**
         * Extracts an array of numbers from the given string excluding all special characters
         * @param  input The input string
         * @return       An array of numbers in the string
         */
        private fun extractNumbers(input: String): List<String> {
            Log.i(TAG, "Extracting numbers from $input")

            return input.split(
                delimiters = *arrayOf("+", "-", "*", "/"),
                ignoreCase = true,
                limit = 0)
        }

        /**
         * Returns the last character of the given string
         * @param  input The input string
         * @return       The last character of the string
         */
        fun getLastCharacter(input: String): String {
            Log.i(TAG, "Return the last character of the string")

            return if (input.isEmpty()) {
                ""
            } else {
                input[input.length - 1].toString()
            }
        }

        /**
         * Checks if the given string is a non-zero digit
         * @param  input The input string
         * @return       true if the given string is a non-zero digit
         */
        fun isNonZeroDigit(input: String): Boolean {
            Log.i(TAG, "Checking if $input is a non-zero digit")

            return input == "1" || input == "2" || input == "3" || input == "4" || input == "5" ||
                    input == "6" || input == "7" || input == "8" || input == "9"
        }

        /**
         * Checks if the given string is zero
         * @param  input The input string
         * @return       true if the given string is zero
         */
        fun isZeroDigit(input: String): Boolean {
            Log.i(TAG, "Checking if $input is zero")

            return input == "0"
        }

        /**
         * Checks if the given string is an operator
         * @param  input The input string
         * @return       true if the given string is an operator
         */
        fun isOperator(input: String): Boolean {
            Log.i(TAG, "Checking if $input is an operator")

            return input == "+" || input == "-" || input == "*" || input == "/"
        }

        /**
         * Checks if the given string is a decimal point
         * @param  input The input string
         * @return       true if the given string is a decimal point
         */
        fun isDecimal(input: String): Boolean {
            Log.i(TAG, "Checking if $input is a decimal point")

            return input == "."
        }

        /**
         * Extracts the last number from the given string
         * @param  input The input string
         * @return       The last number
         */
        fun getLastNumber(input: String): String {
            Log.i(TAG, "Extracting the last number from $input")

            return extractNumbers(input).last()
        }

        /**
         * Checks whether the given number is a decimal number or not
         * @param  input The input string
         * @return       true if the given number is a decimal number (has a decimal point)
         */
        fun isDecimalNumber(input: String): Boolean {
            Log.i(TAG, "Checking if $input is a decimal number")

            return input.contains(".")
        }

        /**
         * Checks whether the given input is an equal sign or not
         * @param  input The input string
         * @return       true if the given string is an equal sign
         */
        fun isEqual(input: String): Boolean {
            Log.i(TAG, "Checking if $input is an equal sign")

            return input == "="
        }

        /**
         * Checks whether the given input is the clear symbol (C)
         * @param  input the input string
         * @return       true if the given string is the clear symbol
         */
        fun isClear(input: String): Boolean {
            Log.i(TAG, "Checking if $input is the clear symbol")

            return input == "C"
        }
    }
}