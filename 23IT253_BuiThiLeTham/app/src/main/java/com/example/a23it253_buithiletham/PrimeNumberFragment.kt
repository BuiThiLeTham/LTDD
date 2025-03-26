package com.example.a23it253_buithiletham


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class PrimeNumberFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_prime_number, container, false)

        val edtNumber = view.findViewById<EditText>(R.id.edtNumber)
        val btnCheckPrime = view.findViewById<Button>(R.id.btnCheckPrime)
        val txtResultPrime = view.findViewById<TextView>(R.id.txtResultPrime)

        btnCheckPrime.setOnClickListener {
            val num = edtNumber.text.toString().toIntOrNull()
            if (num == null) {
                txtResultPrime.text = "Vui lòng nhập số hợp lệ!"
            } else {
                txtResultPrime.text = if (isPrime(num)) "$num là số nguyên tố" else "$num không phải số nguyên tố"
            }
        }
        return view
    }

    private fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        for (i in 2 until n) {
            if (n % i == 0) return false
        }
        return true
    }
}
