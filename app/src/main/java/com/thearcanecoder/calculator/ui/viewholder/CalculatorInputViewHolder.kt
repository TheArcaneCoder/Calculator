package com.thearcanecoder.calculator.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.thearcanecoder.calculator.databinding.ViewHolderCalculatorInputBinding
import com.thearcanecoder.calculator.listener.CalculatorInputClickListener

class CalculatorInputViewHolder(private val binding: ViewHolderCalculatorInputBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(input: String, listener: CalculatorInputClickListener?) {
        binding.input = input
        binding.listener = listener
    }
}