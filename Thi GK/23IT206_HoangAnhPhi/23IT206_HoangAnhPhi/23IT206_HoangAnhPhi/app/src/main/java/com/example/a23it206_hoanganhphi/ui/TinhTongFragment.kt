package com.example.a23it206_hoanganhphi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a23it206_hoanganhphi.R
import com.example.a23it206_hoanganhphi.viewmodel.HocPhanViewModel
import com.google.android.material.textfield.TextInputEditText

class TinhTongFragment : Fragment() {

    private lateinit var viewModel: HocPhanViewModel
    private lateinit var etNumber1: TextInputEditText
    private lateinit var etNumber2: TextInputEditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tinh_tong, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(HocPhanViewModel::class.java)

        // Initialize views
        etNumber1 = view.findViewById(R.id.et_number1)
        etNumber2 = view.findViewById(R.id.et_number2)
        btnCalculate = view.findViewById(R.id.btn_calculate)
        tvResult = view.findViewById(R.id.tv_result)

        // Set up calculate button click listener
        btnCalculate.setOnClickListener {
            calculateSum()
        }
    }

    private fun calculateSum() {
        val number1Str = etNumber1.text.toString().trim()
        val number2Str = etNumber2.text.toString().trim()

        if (number1Str.isEmpty() || number2Str.isEmpty()) {
            Toast.makeText(requireContext(), "Vui lòng nhập đủ hai số", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val number1 = number1Str.toDouble()
            val number2 = number2Str.toDouble()

            val sum = viewModel.sumTwoNumbers(number1, number2)
            tvResult.text = "Kết quả: $sum"
        } catch (e: NumberFormatException) {
            Toast.makeText(requireContext(), "Số không hợp lệ", Toast.LENGTH_SHORT).show()
        }
    }
}
