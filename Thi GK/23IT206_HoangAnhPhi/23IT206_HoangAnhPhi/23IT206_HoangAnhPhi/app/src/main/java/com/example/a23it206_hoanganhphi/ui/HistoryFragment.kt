package com.example.a23it206_hoanganhphi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a23it206_hoanganhphi.R
import com.example.a23it206_hoanganhphi.adapter.NumberHistoryAdapter
import com.example.a23it206_hoanganhphi.viewmodel.PrimeNumberViewModel

class HistoryFragment : Fragment() {
    
    private lateinit var viewModel: PrimeNumberViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NumberHistoryAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(PrimeNumberViewModel::class.java)
        
        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.history_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        
        // Initialize adapter
        adapter = NumberHistoryAdapter()
        recyclerView.adapter = adapter
        
        // Observe data changes
        viewModel.allNumbers.observe(viewLifecycleOwner) { numbers ->
            numbers?.let {
                adapter.submitList(it)
            }
        }
    }
}
