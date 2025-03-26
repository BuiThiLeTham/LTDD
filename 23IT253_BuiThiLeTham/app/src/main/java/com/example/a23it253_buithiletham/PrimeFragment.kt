package com.example.a23it253_buithiletham

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.*
import androidx.fragment.app.Fragment

class PrimeFragment : Fragment() {
    private lateinit var edtNumber: EditText
    private lateinit var btnCheckPrime: Button
    private lateinit var tvResult: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_prime, container, false)
        edtNumber = view.findViewById(R.id.edtNumber)
        btnCheckPrime = view.findViewById(R.id.btnCheckPrime)
        tvResult = view.findViewById(R.id.tvResult)

        btnCheckPrime.setOnClickListener {
            val number = edtNumber.text.toString().trim()
            if (number.isEmpty()) {
                tvResult.text = "Vui lòng nhập số!"
                return@setOnClickListener
            }
            val num = number.toIntOrNull()
            tvResult.text = if (num != null && isPrime(num)) "Số nguyên tố" else "Không phải số nguyên tố"
        }


        return view
    }

    private fun isPrime(num: Int): Boolean {
        if (num < 2) return false
        for (i in 2 until num) {
            if (num % i == 0) return false
        }
        return true
    }
}