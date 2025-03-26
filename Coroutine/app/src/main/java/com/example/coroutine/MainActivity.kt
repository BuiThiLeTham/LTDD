package com.example.coroutine
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNumber1 = findViewById<EditText>(R.id.edtNumber1)
        val edtNumber2 = findViewById<EditText>(R.id.edtNumber2)
        val btnSum = findViewById<Button>(R.id.btnSum)
        val btnDifference = findViewById<Button>(R.id.btnDifference)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Lắng nghe kết quả từ ViewModel
        viewModel.result.observe(this, Observer { result ->
            tvResult.text = "Kết quả: $result"
        })

        btnSum.setOnClickListener {
            val num1 = edtNumber1.text.toString().toIntOrNull() ?: 0
            val num2 = edtNumber2.text.toString().toIntOrNull() ?: 0
            viewModel.calculateSum(num1, num2)
        }

        btnDifference.setOnClickListener {
            val num1 = edtNumber1.text.toString().toIntOrNull() ?: 0
            val num2 = edtNumber2.text.toString().toIntOrNull() ?: 0
            viewModel.calculateDifference(num1, num2)
        }

    }
}
