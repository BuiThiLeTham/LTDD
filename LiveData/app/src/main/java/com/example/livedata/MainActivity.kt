package com.example.livedata

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.Observer



import com.example.livedata.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private val calculatorViewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val edtNumber1 = findViewById<EditText>(R.id.edtNumber1)
        val edtNumber2 = findViewById<EditText>(R.id.edtNumber2)
        val txtSumResult = findViewById<TextView>(R.id.txtSumResult)
        val txtDifferenceResult = findViewById<TextView>(R.id.txtDifferenceResult)

        btnCalculate.setOnClickListener {
            val num1 = edtNumber1.text.toString().toIntOrNull() ?: 0
            val num2 = edtNumber2.text.toString().toIntOrNull() ?: 0

            calculatorViewModel.calculateSum(num1, num2)
            calculatorViewModel.calculateDifference(num1, num2)
        }

        calculatorViewModel.sumResult.observe(this, Observer { sum ->
            txtSumResult.text = "Tổng: $sum"
        })

        calculatorViewModel.differenceResult.observe(this, Observer { difference ->
            txtDifferenceResult.text = "Hiệu: $difference"
        })
    }
}
