package com.example.myapplicationdemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() { // Sửa tên class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvInfo: TextView = findViewById(R.id.tvSecondInfo)
        tvInfo.text = "Chào mừng đến với màn hình thứ hai!"
    }
}
