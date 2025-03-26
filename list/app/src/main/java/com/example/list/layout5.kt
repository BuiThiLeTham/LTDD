package com.example.list
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.list.databinding.ActivityMainBinding
import com.example.list.databinding.Layout5Binding

class layout5  : AppCompatActivity() {
    lateinit var binding: Layout5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Layout5Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val bundle = intent.extras
        val fullname = bundle!!.getString("fullname")
        //Toast.makeText(this,fullname,Toast.LENGTH_SHORT).show()
        binding.tvLogin.text = "Welcome $fullname"
        binding.btnLogin.setOnClickListener {
            if(binding.edtUserName.text.toString().equals("teo") &&
                binding.edtPass.text.toString().equals("123456")){
                Toast.makeText(this,"Login success !",Toast.LENGTH_SHORT).show()
                val myIntent = Intent()
                myIntent.putExtra("msgStatus","Login Success !")
                setResult(Activity.RESULT_OK,myIntent)
                finish()
            }else{
                Toast.makeText(this,"Login fail !",Toast.LENGTH_SHORT).show()
                val myIntent = Intent()
                myIntent.putExtra("msgStatus","Login Fail !")
                setResult(Activity.RESULT_CANCELED,myIntent)
                finish()
            }
        }
    }
}
