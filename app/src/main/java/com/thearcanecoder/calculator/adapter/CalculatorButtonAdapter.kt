package com.thearcanecoder.calculator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.thearcanecoder.calculator.R
import com.thearcanecoder.calculator.data.models.CalculatorButton
import com.thearcanecoder.calculator.listener.CalculatorButtonClickListener
import com.thearcanecoder.calculator.ui.viewholder.CalculatorButtonViewHolder

class CalculatorButtonAdapter(
    private val buttons: List<CalculatorButton>,
    var listener: CalculatorButtonClickListener? = null
) : RecyclerView.Adapter<CalculatorButtonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalculatorButtonViewHolder {
        return CalculatorButtonViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.view_holder_calculator_button,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return buttons.size
    }

    override fun onBindViewHolder(holder: CalculatorButtonViewHolder, position: Int) {
        holder.bind(buttons[position], listener)
    }
}