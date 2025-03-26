package com.example.myapplicationdemo
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Đổi về activity_main.xml

        val btnClickMe: Button = findViewById(R.id.btnClickMe)

        btnClickMe.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}

//class MainActivity : AppCompatActivity() {
//    lateinit var tvInfo:TextView
//    lateinit var btnClickMe:Button
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        tvInfo = findViewById(R.id.tvInfo)
//        btnClickMe = findViewById(R.id.btnClickMe)
//
//        btnClickMe.setOnClickListener {
//            Toast.makeText(this,"Hello Android",Toast.LENGTH_SHORT).show()
//        }
//    }
//}