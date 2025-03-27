package com.example.list

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second) // Sử dụng layout mới

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {

            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
           // finish() // Đóng activity hiện tại và quay lại MainActivity
        }
    }
}
