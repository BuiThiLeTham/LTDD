package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterStudent(private val students: MutableList<Student>) : RecyclerView.Adapter<AdapterStudent.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvStudentId: TextView = itemView.findViewById(R.id.tvIdStudent)
        val tvStudentName: TextView = itemView.findViewById(R.id.tvNameStudent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.tvStudentId.text = student.id.toString()
        holder.tvStudentName.text = student.name
    }

    override fun getItemCount(): Int = students.size

    // Hàm thêm sinh viên mới vào danh sách
    fun addStudent(student: Student) {
        students.add(student)
        notifyItemInserted(students.size - 1)
    }
}
