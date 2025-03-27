package com.example.a23it253_buithiletham.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a23it253_buithiletham.Repository.MayTinhRepository
import com.example.a23it253_buithiletham.ViewModel.MayTinhViewModel

class MayTinhViewModelFactory(private val repository: MayTinhRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MayTinhViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MayTinhViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}