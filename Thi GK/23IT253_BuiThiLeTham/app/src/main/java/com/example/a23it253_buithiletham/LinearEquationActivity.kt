package com.example.a23it253_buithiletham

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LinearEquationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_equation)

        val etA = findViewById<EditText>(R.id.etA)
        val etB = findViewById<EditText>(R.id.etB)
        val btnSolve = findViewById<Button>(R.id.btnSolve)
        val tvSolution = findViewById<TextView>(R.id.tvSolution)

        btnSolve.setOnClickListener {
            val aStr = etA.text.toString()
            val bStr = etB.text.toString()

            if (aStr.isEmpty() || bStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ hệ số", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val a = aStr.toDouble()
            val b = bStr.toDouble()

            val solution = solveLinearEquation(a, b)
            tvSolution.text = solution
        }
    }

    private fun solveLinearEquation(a: Double, b: Double): String {
        return when {
            a == 0.0 && b == 0.0 -> "Phương trình có vô số nghiệm"
            a == 0.0 -> "Phương trình vô nghiệm"
            else -> "Nghiệm: x = ${-b / a}"
        }
    }
}