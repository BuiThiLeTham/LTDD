package com.example.a23it253_buithiletham

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PerfectNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfect_number)

        val etNumber = findViewById<EditText>(R.id.etNumber)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCheck.setOnClickListener {
            val numberStr = etNumber.text.toString()
            if (numberStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập số", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val number = numberStr.toInt()
            if (isPerfectNumber(number)) {
                tvResult.text = "$number là số hoàn hảo"
            } else {
                tvResult.text = "$number không phải là số hoàn hảo"
            }
        }
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