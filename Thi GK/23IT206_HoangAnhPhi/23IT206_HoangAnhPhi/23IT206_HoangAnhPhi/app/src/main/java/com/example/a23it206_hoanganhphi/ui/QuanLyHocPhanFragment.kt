package com.example.a23it206_hoanganhphi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a23it206_hoanganhphi.R
import com.example.a23it206_hoanganhphi.adapter.HocPhanAdapter
import com.example.a23it206_hoanganhphi.data.HocPhan
import com.example.a23it206_hoanganhphi.viewmodel.HocPhanViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class QuanLyHocPhanFragment : Fragment() {

    private lateinit var viewModel: HocPhanViewModel
    private lateinit var adapter: HocPhanAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var etTenHocPhan: TextInputEditText
    private lateinit var etSoTinChi: TextInputEditText
    private lateinit var etHocKy: TextInputEditText
    private lateinit var btnSave: Button
    private var currentHocPhan: HocPhan? = null
    private var isEditMode = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quan_ly_hoc_phan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(HocPhanViewModel::class.java)

        // Initialize views
        etTenHocPhan = view.findViewById(R.id.et_ten_hoc_phan)
        etSoTinChi = view.findViewById(R.id.et_so_tin_chi)
        etHocKy = view.findViewById(R.id.et_hoc_ky)
        btnSave = view.findViewById(R.id.btn_save)
        recyclerView = view.findViewById(R.id.rv_hoc_phan)

        // Set up RecyclerView
        adapter = HocPhanAdapter(
            onItemClick = { hocPhan -> showEditDialog(hocPhan) },
            onDeleteClick = { hocPhan -> showDeleteConfirmationDialog(hocPhan) }
        )
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Set up save button click listener
        btnSave.setOnClickListener {
            saveHocPhan()
        }

        // Observe HocPhan data
        viewModel.allHocPhan.observe(viewLifecycleOwner) { hocPhans ->
            adapter.submitList(hocPhans)
            if (hocPhans.isNotEmpty()) {
                // Debug log to verify data is being received
                println("Loaded ${hocPhans.size} học phần from database")
            }
        }
    }

    private fun saveHocPhan() {
        val tenHocPhan = etTenHocPhan.text.toString().trim()
        val soTinChiStr = etSoTinChi.text.toString().trim()
        val hocKy = etHocKy.text.toString().trim()

        println("Đang lưu học phần: $tenHocPhan, $soTinChiStr tín chỉ, học kỳ $hocKy")

        if (tenHocPhan.isEmpty() || soTinChiStr.isEmpty() || hocKy.isEmpty()) {
            Toast.makeText(requireContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            return
        }

        val soTinChi = soTinChiStr.toIntOrNull()
        if (soTinChi == null || soTinChi <= 0) {
            Toast.makeText(requireContext(), "Số tín chỉ không hợp lệ", Toast.LENGTH_SHORT).show()
            return
        }

        if (isEditMode && currentHocPhan != null) {
            // Update existing HocPhan
            val updatedHocPhan = currentHocPhan!!.copy(
                tenhocphan = tenHocPhan,
                sotinchi = soTinChi,
                hocky = hocKy
            )
            viewModel.update(updatedHocPhan)
            println("Đã cập nhật học phần ID: ${updatedHocPhan.mahocphan}")
            Toast.makeText(requireContext(), "Cập nhật học phần thành công", Toast.LENGTH_SHORT).show()
        } else {
            // Create new HocPhan
            val newHocPhan = HocPhan(
                tenhocphan = tenHocPhan,
                sotinchi = soTinChi,
                hocky = hocKy
            )
            viewModel.insert(newHocPhan)
            println("Đã thêm học phần mới: $tenHocPhan")
            Toast.makeText(requireContext(), "Thêm học phần thành công", Toast.LENGTH_SHORT).show()
        }

        // Clear fields and reset mode
        clearFields()
        isEditMode = false
        currentHocPhan = null
        btnSave.text = "Lưu học phần"
    }

    private fun showEditDialog(hocPhan: HocPhan) {
        currentHocPhan = hocPhan
        isEditMode = true
        
        // Fill fields with HocPhan data
        etTenHocPhan.setText(hocPhan.tenhocphan)
        etSoTinChi.setText(hocPhan.sotinchi.toString())
        etHocKy.setText(hocPhan.hocky)
        
        // Update button text
        btnSave.text = "Cập nhật học phần"
        
        // Scroll to top to show the form
        recyclerView.smoothScrollToPosition(0)
    }

    private fun showDeleteConfirmationDialog(hocPhan: HocPhan) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Xác nhận xóa")
            .setMessage("Bạn có chắc chắn muốn xóa học phần '${hocPhan.tenhocphan}'?")
            .setNegativeButton("Hủy") { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Xóa") { _, _ ->
                viewModel.delete(hocPhan)
                Toast.makeText(requireContext(), "Đã xóa học phần", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun clearFields() {
        etTenHocPhan.text?.clear()
        etSoTinChi.text?.clear()
        etHocKy.text?.clear()
    }
}
