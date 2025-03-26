package com.example.bt2
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
class StudentAdapter(var context:Activity,var layout:Int,var
lstStudent:ArrayList<Student>):BaseAdapter() {
    override fun getCount(): Int {
        return lstStudent.size
    }
    override fun getItem(position: Int): Any {
        return lstStudent.get(position)
    }
    override fun getItemId(position: Int): Long {
        return lstStudent[position].id.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = context.layoutInflater
        val view = layoutInflater.inflate(R.layout.row_student,parent,false)
        val tvIdStudent = view.findViewById<TextView>(R.id.tvIdStudent)
        val tvNameStudent = view.findViewById<TextView>(R.id.tvNameStudent)
        tvIdStudent.text = lstStudent[position].id.toString()
        tvNameStudent.text = lstStudent[position].name.toString()
        return view
    }
}