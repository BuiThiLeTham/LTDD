package com.example.a23it206_hoanganhphi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a23it206_hoanganhphi.R
import com.example.a23it206_hoanganhphi.data.NumberEntity
import java.text.SimpleDateFormat
import java.util.Locale

class NumberHistoryAdapter : RecyclerView.Adapter<NumberHistoryAdapter.NumberViewHolder>() {
    
    private var numbers: List<NumberEntity> = ArrayList()
    
    fun submitList(newList: List<NumberEntity>) {
        numbers = newList
        notifyDataSetChanged()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_number_history, parent, false)
        return NumberViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val currentItem = numbers[position]
        holder.bind(currentItem)
    }
    
    override fun getItemCount(): Int = numbers.size
    
    inner class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numberText: TextView = itemView.findViewById(R.id.number_text)
        private val resultText: TextView = itemView.findViewById(R.id.result_text)
        private val timestampText: TextView = itemView.findViewById(R.id.timestamp_text)
        
        fun bind(numberEntity: NumberEntity) {
            numberText.text = numberEntity.number.toString()
            resultText.text = "Is Prime: ${if (numberEntity.isPrime) "Yes" else "No"}"
            
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
            timestampText.text = dateFormat.format(numberEntity.timestamp)
        }
    }
}
