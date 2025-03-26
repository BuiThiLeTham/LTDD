package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Tạo một TextView và hiển thị dòng chữ "Hello, World!"
        val textView = TextView(this)
        textView.text = "Hello, World!"
        textView.textSize = 24f
        setContentView(textView)
    }
}
