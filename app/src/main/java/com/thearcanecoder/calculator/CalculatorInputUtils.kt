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
         * Fetches the last number that is entered
         * The number can consist of several digits as well as a decimal point
         * @param  input The input string
         * @return       The number that is being entered
         */
        fun getLastNumber(input: String): String {
            Log.i(TAG, "Retrieving the last number of the string")

            return input.split(
                delimiters = *arrayOf("+", "-", "*", "/"),
                ignoreCase = true,
                limit = 0).last()
        }

        /**
         * Checks if the given string is a digit
         * @param  input The input string
         * @return       true if the given string is a digit
         */
        fun isDigit(input: String): Boolean {
            Log.i(TAG, "Checking if $input is a digit")

            return input == "0" || input == "1" || input == "2" || input == "3" || input == "4" ||
                    input == "5" || input == "6" || input == "7" || input == "8" || input == "9"
        }

        /**
         * Checks if the given string is a non-zero digit
         * @param  input The input string
         * @return       true if the given string is a non-zero digit
         */
        fun isNonZeroDigit(input: String): Boolean {
            Log.i(TAG, "Checking if $input is a non-zero digit")

            return input != "0"
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
         * Extracts an array of numbers from the given string excluding all special characters
         * @param  input The input string
         * @return       An array of numbers in the string
         */
        fun extractNumbers(input: String): Array<Int> {
            Log.i(TAG, "Extracting numbers from $input")

            val splitString: List<String> =
                input.split(delimiters = *arrayOf("+", "-", "*", "/"), ignoreCase = true, limit = 0)
            val numbers: Array<Int> = Array(splitString.size) { 0 }
            splitString.forEach {
                numbers[splitString.indexOf(it)] = Integer.parseInt(it)
            }

            return numbers
        }
    }
}