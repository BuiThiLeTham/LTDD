package com.example.a23it253_buithiletham

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a23it253_buithiletham.Adapter.MayTinhAdapter
import com.example.a23it253_buithiletham.Database.AppDatabase
import com.example.a23it253_buithiletham.Entity.MayTinh
import com.example.a23it253_buithiletham.Repository.MayTinhRepository
import com.example.a23it253_buithiletham.ViewModel.MayTinhViewModel
import com.example.a23it253_buithiletham.ViewModelFactory.MayTinhViewModelFactory

class ComputerManagementFragment : Fragment() {
    private lateinit var rvMayTinh: RecyclerView
    private lateinit var btnAdd: Button
    private lateinit var adapter: MayTinhAdapter
    private lateinit var viewModel: MayTinhViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_computer_management, container, false)

        rvMayTinh = view.findViewById(R.id.rvMayTinh)
        btnAdd = view.findViewById(R.id.btnAdd)

        val factory = MayTinhViewModelFactory(
            MayTinhRepository(
                AppDatabase.getDatabase(requireContext()).mayTinhDao()
            )
        )
        viewModel = ViewModelProvider(this, factory).get(MayTinhViewModel::class.java)

        rvMayTinh.layoutManager = LinearLayoutManager(requireContext())
        adapter = MayTinhAdapter(
            emptyList(),
            onItemClick = { showMayTinhDetails(it) },
            onDeleteClick = { confirmDeleteMayTinh(it) },
            onUpdateClick = { showUpdateDialog(it) }
        )
        rvMayTinh.adapter = adapter

        btnAdd.setOnClickListener {
            showAddDialog()
        }

        viewModel.allMayTinh.observe(viewLifecycleOwner) { mayTinhList ->
            mayTinhList?.let { adapter.updateList(it) }
        }

        return view
    }

    private fun showAddDialog() {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_update_may_tinh, null)
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Thêm máy tính mới")
            .setView(dialogView)
            .create()

        val etTenMay = dialogView.findViewById<EditText>(R.id.etTenMay)
        val etLoaiMay = dialogView.findViewById<EditText>(R.id.etLoaiMay)
        val etSoLuong = dialogView.findViewById<EditText>(R.id.etSoLuong)
        val etDonGia = dialogView.findViewById<EditText>(R.id.etDonGia)
        val btnSave = dialogView.findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val tenMay = etTenMay.text.toString()
            val loaiMay = etLoaiMay.text.toString()
            val soLuong = etSoLuong.text.toString().toIntOrNull() ?: 0
            val donGia = etDonGia.text.toString().toDoubleOrNull() ?: 0.0

            if (tenMay.isEmpty() || loaiMay.isEmpty() || soLuong <= 0 || donGia <= 0) {
                Toast.makeText(requireContext(), "Vui lòng nhập đủ thông tin hợp lệ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val mayTinh = MayTinh(
                tenmay = tenMay,
                loaimay = loaiMay,
                soluong = soLuong,
                dongia = donGia
            )

            viewModel.insert(mayTinh)
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showUpdateDialog(mayTinh: MayTinh) {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_update_may_tinh, null)
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Cập nhật máy tính")
            .setView(dialogView)
            .create()

        val etTenMay = dialogView.findViewById<EditText>(R.id.etTenMay)
        val etLoaiMay = dialogView.findViewById<EditText>(R.id.etLoaiMay)
        val etSoLuong = dialogView.findViewById<EditText>(R.id.etSoLuong)
        val etDonGia = dialogView.findViewById<EditText>(R.id.etDonGia)
        val btnSave = dialogView.findViewById<Button>(R.id.btnSave)

        etTenMay.setText(mayTinh.tenmay)
        etLoaiMay.setText(mayTinh.loaimay)
        etSoLuong.setText(mayTinh.soluong.toString())
        etDonGia.setText(mayTinh.dongia.toString())

        btnSave.setOnClickListener {
            val tenMay = etTenMay.text.toString()
            val loaiMay = etLoaiMay.text.toString()
            val soLuong = etSoLuong.text.toString().toIntOrNull() ?: 0
            val donGia = etDonGia.text.toString().toDoubleOrNull() ?: 0.0

            if (tenMay.isEmpty() || loaiMay.isEmpty() || soLuong <= 0 || donGia <= 0) {
                Toast.makeText(requireContext(), "Vui lòng nhập đủ thông tin hợp lệ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val updatedMayTinh = mayTinh.copy(
                tenmay = tenMay,
                loaimay = loaiMay,
                soluong = soLuong,
                dongia = donGia
            )

            viewModel.update(updatedMayTinh)
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun confirmDeleteMayTinh(mayTinh: MayTinh) {
        AlertDialog.Builder(requireContext())
            .setTitle("Xác nhận xóa")
            .setMessage("Bạn có chắc chắn muốn xóa ${mayTinh.tenmay}?")
            .setPositiveButton("Xóa") { _, _ ->
                viewModel.delete(mayTinh)
            }
            .setNegativeButton("Hủy", null)
            .show()
    }

    private fun showMayTinhDetails(mayTinh: MayTinh) {
        AlertDialog.Builder(requireContext())
            .setTitle("Thông tin chi tiết")
            .setMessage(
                "Tên máy: ${mayTinh.tenmay}\n" +
                        "Loại máy: ${mayTinh.loaimay}\n" +
                        "Số lượng: ${mayTinh.soluong}\n" +
                        "Đơn giá: ${mayTinh.dongia}\n" +
                        "Thành tiền: ${mayTinh.thanhTien()}"
            )
            .setPositiveButton("Đóng", null)
            .show()
    }
}