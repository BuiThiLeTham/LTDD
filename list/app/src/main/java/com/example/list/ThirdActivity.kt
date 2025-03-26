package com.example.list

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    lateinit var a:EditText
    lateinit var b:EditText
    lateinit var tvKetQua:TextView
    lateinit var btnCong:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third) // Sử dụng layout mới
        controls() //hàm Khởi tạo các thành phần giao diện
        events()  // Xử lý sự kiện
        val back2Button = findViewById<Button>(R.id.back2Button)
        back2Button.setOnClickListener {

            //val intent = Intent(this, ThirdActivity::class.java)

            finish()
        }


        }
    private fun controls(){
        a = findViewById<EditText>(R.id.edtSoA)
        b = findViewById<EditText>(R.id.edtSoB)
        tvKetQua = findViewById<TextView>(R.id.tvKetQua)
        btnCong = findViewById<Button>(R.id.btnCong)
    }
    private fun events(){
        btnCong.setOnClickListener {
            var kq:Int = 0
            kq = a.text.toString().toInt() + b.text.toString().toInt()
            tvKetQua.text = kq.toString()
        }
    }
}