package com.thearcanecoder.calculator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.thearcanecoder.calculator.R
import com.thearcanecoder.calculator.listener.CalculatorInputClickListener
import com.thearcanecoder.calculator.ui.viewholder.CalculatorInputViewHolder

class CalculatorInputAdapter(
    private val calculatorInput: ArrayList<String>,
    var listener: CalculatorInputClickListener? = null
) : RecyclerView.Adapter<CalculatorInputViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalculatorInputViewHolder {
        return CalculatorInputViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.view_holder_calculator_input,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return calculatorInput.size
    }

    override fun onBindViewHolder(holder: CalculatorInputViewHolder, position: Int) {
        holder.bind(calculatorInput[position], listener)
    }

    fun addNewInput(input: String) {
        calculatorInput.add(0, input)
        notifyItemInserted(0)
    }
}