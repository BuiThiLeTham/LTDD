package com.example.a23it253_buithiletham

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class SumFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sum, container, false)

        val edtNumber1 = view.findViewById<EditText>(R.id.edtNumber1)
        val edtNumber2 = view.findViewById<EditText>(R.id.edtNumber2)
        val btnCalculateSum = view.findViewById<Button>(R.id.btnCalculateSum)
        val txtResultSum = view.findViewById<TextView>(R.id.txtResultSum)

        btnCalculateSum.setOnClickListener {
            val num1 = edtNumber1.text.toString().toFloatOrNull()
            val num2 = edtNumber2.text.toString().toFloatOrNull()
            txtResultSum.text = if (num1 != null && num2 != null) "Tổng = ${num1 + num2}" else "Vui lòng nhập số hợp lệ!"
        }
        return view
    }
}
