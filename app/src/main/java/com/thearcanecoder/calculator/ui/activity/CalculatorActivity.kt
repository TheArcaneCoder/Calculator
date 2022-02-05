package com.thearcanecoder.calculator.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thearcanecoder.calculator.R
import com.thearcanecoder.calculator.adapter.CalculatorButtonAdapter
import com.thearcanecoder.calculator.adapter.CalculatorInputAdapter
import com.thearcanecoder.calculator.data.models.CalculatorButton
import com.thearcanecoder.calculator.databinding.ActivityCalculatorBinding
import com.thearcanecoder.calculator.listener.CalculatorButtonClickListener
import com.thearcanecoder.calculator.listener.CalculatorInputClickListener
import com.thearcanecoder.calculator.util.AppConstants
import com.thearcanecoder.calculator.viewmodel.CalculatorViewModel

/**
 * This is the main screen which shows the calculator UI to the user
 */
class CalculatorActivity :
    AppCompatActivity(),
    CalculatorButtonClickListener,
    CalculatorInputClickListener {

    private lateinit var binding: ActivityCalculatorBinding

    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this@CalculatorActivity,
            R.layout.activity_calculator
        )

        initUi()
    }

    private fun initUi() {
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

        viewModel.currentInput.observe(this) { input ->
            binding.tvCurrentInput.text = input
        }

        viewModel.inputHistory.observe(this) { inputHistory ->
            (binding.rvPreviousInput.adapter as? CalculatorInputAdapter)?.let {
                if (inputHistory.isNotEmpty()) {
                    it.addNewInput(inputHistory.last())
                    binding.rvPreviousInput.scrollToPosition(0)
                }
            }
        }
    }

    override fun onButtonClick(button: CalculatorButton) {
        viewModel.handleInput(button)
    }

    override fun onCalculatorInputClick(index: Int) {
        viewModel.loadPreviousInput(index)
    }
}