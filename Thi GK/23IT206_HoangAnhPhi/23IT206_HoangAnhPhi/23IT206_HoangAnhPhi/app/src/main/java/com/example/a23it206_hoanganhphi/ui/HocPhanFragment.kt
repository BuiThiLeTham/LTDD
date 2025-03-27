package com.example.a23it206_hoanganhphi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a23it206_hoanganhphi.R
import com.example.a23it206_hoanganhphi.adapter.HocPhanAdapter
import com.example.a23it206_hoanganhphi.viewmodel.HocPhanViewModel

class HocPhanFragment : Fragment() {

    private lateinit var viewModel: HocPhanViewModel
    private lateinit var adapter: HocPhanAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hoc_phan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(HocPhanViewModel::class.java)
        
        // Initialize views
        recyclerView = view.findViewById(R.id.rv_hoc_phan_list)
        emptyTextView = view.findViewById(R.id.tv_empty_list)
        
        // Set up RecyclerView
        adapter = HocPhanAdapter(
            onItemClick = { /* Chỉ xem, không cần xử lý sự kiện click */ },
            onDeleteClick = { /* Chỉ xem, không cần xử lý sự kiện xóa */ }
        )
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        
        // Observe HocPhan data
        viewModel.allHocPhan.observe(viewLifecycleOwner) { hocPhans ->
            adapter.submitList(hocPhans)
            
            // Hiển thị thông báo nếu danh sách trống
            if (hocPhans.isEmpty()) {
                emptyTextView.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            } else {
                emptyTextView.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                println("Đã tải ${hocPhans.size} học phần")
            }
        }
    }
}
