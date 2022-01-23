package com.thearcanecoder.calculator.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.thearcanecoder.calculator.data.CalculatorButton
import com.thearcanecoder.calculator.databinding.ViewHolderCalculatorButtonBinding
import com.thearcanecoder.calculator.listener.CalculatorButtonClickListener

class CalculatorButtonViewHolder(private val binding: ViewHolderCalculatorButtonBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(button: CalculatorButton, listener: CalculatorButtonClickListener?) {
        binding.button = button
        binding.listener = listener
    }
}