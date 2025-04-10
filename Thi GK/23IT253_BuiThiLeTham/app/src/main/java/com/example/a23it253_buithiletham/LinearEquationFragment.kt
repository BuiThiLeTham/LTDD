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

class LinearEquationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_linear_equation, container, false)

        val etA = view.findViewById<EditText>(R.id.etA)
        val etB = view.findViewById<EditText>(R.id.etB)
        val btnSolve = view.findViewById<Button>(R.id.btnSolve)
        val tvSolution = view.findViewById<TextView>(R.id.tvSolution)

        btnSolve.setOnClickListener {
            val aStr = etA.text.toString()
            val bStr = etB.text.toString()

            if (aStr.isEmpty() || bStr.isEmpty()) {
                Toast.makeText(requireContext(), "Vui lòng nhập đủ hệ số", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val a = aStr.toDouble()
            val b = bStr.toDouble()

            val solution = solveLinearEquation(a, b)
            tvSolution.text = solution
        }

        return view
    }

    private fun solveLinearEquation(a: Double, b: Double): String {
        return when {
            a == 0.0 && b == 0.0 -> "Phương trình có vô số nghiệm"
            a == 0.0 -> "Phương trình vô nghiệm"
            else -> "Nghiệm: x = ${-b / a}"
        }
    }
}