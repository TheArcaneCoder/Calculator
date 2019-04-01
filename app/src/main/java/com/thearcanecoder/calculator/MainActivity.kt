package com.thearcanecoder.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

/**
 * The main calculator screen
 * @author Bilal Naeem
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mButton0: Button
    private lateinit var mButton1: Button
    private lateinit var mButton2: Button
    private lateinit var mButton3: Button
    private lateinit var mButton4: Button
    private lateinit var mButton5: Button
    private lateinit var mButton6: Button
    private lateinit var mButton7: Button
    private lateinit var mButton8: Button
    private lateinit var mButton9: Button
    private lateinit var mButtonPlus: Button
    private lateinit var mButtonMinus: Button
    private lateinit var mButtonMultiply: Button
    private lateinit var mButtonDivide: Button
    private lateinit var mButtonClear: Button
    private lateinit var mButtonSign: Button
    private lateinit var mButtonBracket: Button
    private lateinit var mButtonPercent: Button
    private lateinit var mButtonDecimal: Button
    private lateinit var mButtonEqual: Button

    private lateinit var mInputField: TextView
    private lateinit var mResultField: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUiElements()
        setupListeners()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            mButton0.id, mButton1.id, mButton2.id, mButton3.id, mButton4.id, mButton5.id, mButton6.id,
            mButton7.id, mButton8.id, mButton9.id, mButtonPlus.id, mButtonMinus.id, mButtonMultiply.id,
            mButtonDivide.id, mButtonBracket.id, mButtonPercent.id, mButtonDecimal.id, mButtonSign.id -> {
                mInputField.text = CalculatorButtonHandler.getStringToAdd(
                    mInputField.text.toString(), (v as Button).text.toString())
            }
            mButtonClear.id -> {
                mInputField.text = ""
                mResultField.text = ""
            }
            mButtonEqual.id -> {
                mResultField.text = CalculatorButtonHandler.getStringToAdd(
                    mInputField.text.toString(), (v as Button).text.toString())
            }
        }
    }

    /**
     * Initializes all the buttons in the view
     */
    private fun initializeUiElements() {
        mButton0 = findViewById(R.id.button_0)
        mButton1 = findViewById(R.id.button_1)
        mButton2 = findViewById(R.id.button_2)
        mButton3 = findViewById(R.id.button_3)
        mButton4 = findViewById(R.id.button_4)
        mButton5 = findViewById(R.id.button_5)
        mButton6 = findViewById(R.id.button_6)
        mButton7 = findViewById(R.id.button_7)
        mButton8 = findViewById(R.id.button_8)
        mButton9 = findViewById(R.id.button_9)
        mButtonPlus = findViewById(R.id.button_plus)
        mButtonMinus = findViewById(R.id.button_minus)
        mButtonMultiply = findViewById(R.id.button_multiply)
        mButtonDivide = findViewById(R.id.button_divide)
        mButtonClear = findViewById(R.id.button_clear)
        mButtonSign = findViewById(R.id.button_sign)
        mButtonBracket = findViewById(R.id.button_bracket)
        mButtonPercent = findViewById(R.id.button_percent)
        mButtonDecimal = findViewById(R.id.button_decimal)
        mButtonEqual = findViewById(R.id.button_equal)

        mInputField = findViewById(R.id.input_field)
        mResultField = findViewById(R.id.result_field)
    }

    /**
     * Setup listeners on all the buttons
     */
    private fun setupListeners() {
        mButton0.setOnClickListener(this)
        mButton1.setOnClickListener(this)
        mButton2.setOnClickListener(this)
        mButton3.setOnClickListener(this)
        mButton4.setOnClickListener(this)
        mButton5.setOnClickListener(this)
        mButton6.setOnClickListener(this)
        mButton7.setOnClickListener(this)
        mButton8.setOnClickListener(this)
        mButton9.setOnClickListener(this)
        mButtonPlus.setOnClickListener(this)
        mButtonMinus.setOnClickListener(this)
        mButtonMultiply.setOnClickListener(this)
        mButtonDivide.setOnClickListener(this)
        mButtonClear.setOnClickListener(this)
        mButtonSign.setOnClickListener(this)
        mButtonBracket.setOnClickListener(this)
        mButtonPercent.setOnClickListener(this)
        mButtonDecimal.setOnClickListener(this)
        mButtonEqual.setOnClickListener(this)
    }
}
