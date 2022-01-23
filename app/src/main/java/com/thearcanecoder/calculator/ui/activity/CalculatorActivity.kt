package com.thearcanecoder.calculator.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thearcanecoder.calculator.R
import com.thearcanecoder.calculator.adapter.CalculatorButtonAdapter
import com.thearcanecoder.calculator.adapter.CalculatorInputAdapter
import com.thearcanecoder.calculator.data.CalculatorButton
import com.thearcanecoder.calculator.data.enum.ButtonType
import com.thearcanecoder.calculator.databinding.ActivityCalculatorBinding
import com.thearcanecoder.calculator.listener.CalculatorButtonClickListener
import com.thearcanecoder.calculator.listener.CalculatorInputClickListener
import com.thearcanecoder.calculator.util.AppConstants

class CalculatorActivity :
    AppCompatActivity(),
    CalculatorButtonClickListener,
    CalculatorInputClickListener {

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this@CalculatorActivity,
            R.layout.activity_calculator
        )

        binding.rvCalculator.let {
            it.layoutManager = GridLayoutManager(
                this@CalculatorActivity,
                4,
                RecyclerView.VERTICAL,
                false
            )
            it.adapter = CalculatorButtonAdapter(
                AppConstants.calculatorButtons,
                this@CalculatorActivity
            )
        }

        binding.rvPreviousInput.let {
            it.layoutManager = LinearLayoutManager(
                this@CalculatorActivity,
                RecyclerView.VERTICAL,
                true
            )
            it.adapter = CalculatorInputAdapter(
                ArrayList(),
                this@CalculatorActivity
            )
        }
    }

    override fun onButtonClick(button: CalculatorButton) {
        if (button.type == ButtonType.EVALUATE) {
            (binding.rvPreviousInput.adapter as CalculatorInputAdapter?)?.let {
                it.addNewInput(binding.tvCurrentInput.text.toString())
                binding.rvPreviousInput.scrollToPosition(0)
            }

            binding.tvCurrentInput.text = ""
        } else if (button.type == ButtonType.CLEAR) {
            if (binding.tvCurrentInput.text.isNotEmpty()) {
                binding.tvCurrentInput.text = binding.tvCurrentInput.text.substring(
                    0,
                    binding.tvCurrentInput.text.lastIndex
                )
            }
        } else {
            binding.tvCurrentInput.text = binding.tvCurrentInput.text.toString() + button.text
        }
    }

    override fun onCalculatorInputClick(input: String) {
        binding.tvCurrentInput.text = input
    }
}