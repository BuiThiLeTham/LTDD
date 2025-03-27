package com.example.a23it206_hoanganhphi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a23it206_hoanganhphi.R
import com.example.a23it206_hoanganhphi.data.NumberEntity
import com.example.a23it206_hoanganhphi.viewmodel.PrimeNumberViewModel
import com.google.android.material.textfield.TextInputEditText
import java.util.Date

class PrimeNumberFragment : Fragment() {
    
    private lateinit var viewModel: PrimeNumberViewModel
    private lateinit var numberInput: TextInputEditText
    private lateinit var checkButton: Button
    private lateinit var resultText: TextView
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_prime_number, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(PrimeNumberViewModel::class.java)
        
        // Initialize views
        numberInput = view.findViewById(R.id.number_input)
        checkButton = view.findViewById(R.id.check_button)
        resultText = view.findViewById(R.id.result_text)
        
        // Set click listener for check button
        checkButton.setOnClickListener {
            val numberString = numberInput.text.toString()
            if (numberString.isNotEmpty()) {
                val number = numberString.toLong()
                val isPrime = viewModel.isPrimeNumber(number)
                
                // Display result
                val resultMessage = if (isPrime) {
                    "$number là số nguyên tố"
                } else {
                    "$number không phải là số nguyên tố"
                }
                resultText.text = resultMessage
                
                // Save to database
                val numberEntity = NumberEntity(
                    number = number,
                    isPrime = isPrime,
                    timestamp = Date()
                )
                viewModel.insertNumber(numberEntity)
            } else {
                resultText.text = "Vui lòng nhập một số"
            }
        }
    }
}
