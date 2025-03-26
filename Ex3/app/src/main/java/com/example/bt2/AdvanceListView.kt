package com.example.bt2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bt2.databinding.ActivityAdvanceListViewBinding

class AdvanceListView : AppCompatActivity() {
    lateinit var binding:ActivityAdvanceListViewBinding
    var lstStudent = ArrayList<Student>()
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvanceListViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if(lstStudent.isEmpty()){
            lstStudent.add(Student(1,"Nguyen Van A"))
            lstStudent.add(Student(2,"Nguyen Van A"))
            lstStudent.add(Student(3,"Nguyen Van A"))
            val studentAdapter = StudentAdapter(this,R.layout.row_student,lstStudent)
            binding.lvStudentNew.adapter = studentAdapter
        }
        binding.btnAddStudent.setOnClickListener {
            val myIntent = Intent(this,AddStudentActivity::class.java)
            myIntent.putExtra("lstStudent",lstStudent)
            startActivityForResult(myIntent,200)
        }
    }
    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 200){
            if(resultCode == Activity.RESULT_OK){
                val bundle = data!!.extras
                lstStudent = bundle!!.getSerializable("lstStudent") as ArrayList<Student>
                val studentAdapter = StudentAdapter(this,R.layout.row_student,lstStudent)
                binding.lvStudentNew.adapter = studentAdapter
            }
        }
    }
}