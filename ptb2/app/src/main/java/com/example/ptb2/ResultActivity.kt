package com.example.ptb2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Nhận dữ liệu từ Intent
        val a = intent.getDoubleExtra("A", 0.0)
        val b = intent.getDoubleExtra("B", 0.0)
        val c = intent.getDoubleExtra("C", 0.0)

        // Giải phương trình bậc 2
        val delta = b * b - 4 * a * c
        val result = when {
            a == 0.0 -> "Không phải phương trình bậc 2!"
            delta < 0 -> "Phương trình vô nghiệm"
            delta == 0.0 -> "Phương trình có nghiệm kép: x = ${-b / (2 * a)}"
            else -> {
                val x1 = (-b + sqrt(delta)) / (2 * a)
                val x2 = (-b - sqrt(delta)) / (2 * a)
                "Phương trình có 2 nghiệm:\n x1 = $x1\n x2 = $x2"
            }
        }

        // Hiển thị kết quả
        tvResult.text = result
    }
}
