package com.example.ptb2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtA = findViewById<EditText>(R.id.edtA)
        val edtB = findViewById<EditText>(R.id.edtB)
        val edtC = findViewById<EditText>(R.id.edtC)
        val btnSolve = findViewById<Button>(R.id.btnSolve)

        btnSolve.setOnClickListener {
            val a = edtA.text.toString().toDoubleOrNull() ?: 0.0
            val b = edtB.text.toString().toDoubleOrNull() ?: 0.0
            val c = edtC.text.toString().toDoubleOrNull() ?: 0.0

            // Tạo Intent để gửi dữ liệu sang ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("A", a)
            intent.putExtra("B", b)
            intent.putExtra("C", c)
            startActivity(intent)
        }
    }
}
