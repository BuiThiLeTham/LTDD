package com.example.bt2
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.bt2.databinding.ActivityAddStudentBinding

class AddStudentActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddStudentBinding
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val bundle = intent.extras
        var lstStudent:ArrayList<Student> = bundle!!.getSerializable("lstStudent") as
                ArrayList<Student>

//Toast.makeText(this,lstStudent.get(0).name.toString(),Toast.LENGTH_SHORT).show()
        binding.btnSave.setOnClickListener {
            val idStudent = binding.edtAddId.text.toString().toInt()
            val nameStudent = binding.edtAddName.text.toString()
            if(TextUtils.isEmpty(nameStudent) &&
                TextUtils.isEmpty(idStudent.toString())){
                Toast.makeText(this,"Bạn chưa nhập dữ liệu hoặc không hợp lệ!",Toast.LENGTH_SHORT).show()
            }
            else{
                val myIntent = Intent()
                myIntent.putExtra("lstStudent",lstStudent)
                lstStudent.add(Student(idStudent!!,nameStudent!!))
                setResult(Activity.RESULT_OK,myIntent)
                finish()
            }
        }
    }
}
