package com.example.a23it253_buithiletham

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class PerfectNumberFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_perfect_number, container, false)

        val etNumber = view.findViewById<EditText>(R.id.etNumber)
        val btnCheck = view.findViewById<Button>(R.id.btnCheck)
        val tvResult = view.findViewById<TextView>(R.id.tvResult)

        btnCheck.setOnClickListener {
            val numberStr = etNumber.text.toString()
            if (numberStr.isEmpty()) {
                Toast.makeText(requireContext(), "Vui lòng nhập số", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val number = numberStr.toInt()
            if (isPerfectNumber(number)) {
                tvResult.text = "$number là số hoàn hảo"
            } else {
                tvResult.text = "$number không phải là số hoàn hảo"
            }
        }

        return view
    }

    private fun isPerfectNumber(number: Int): Boolean {
        if (number <= 1) return false

        var sum = 1
        for (i in 2..number / 2) {
            if (number % i == 0) {
                sum += i
            }
        }

        return sum == number
    }
}