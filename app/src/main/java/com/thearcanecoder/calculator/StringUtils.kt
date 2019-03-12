package com.thearcanecoder.calculator

import android.util.Log

class StringUtils {
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
         * Checks if the given string is an operator
         * @param  input The input string
         * @return       true if the given string is an operator
         */
        fun isOperator(input: String): Boolean {
            Log.i(TAG, "Checking if $input is an operator")

            return input == "+" || input == "-" || input == "*" || input == "/"
        }
    }
}