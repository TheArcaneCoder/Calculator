package com.thearcanecoder.calculator

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
        return ""
    }
}