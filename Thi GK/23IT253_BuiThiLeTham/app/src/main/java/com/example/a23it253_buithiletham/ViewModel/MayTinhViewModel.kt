package com.example.a23it253_buithiletham.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a23it253_buithiletham.Entity.MayTinh
import com.example.a23it253_buithiletham.Repository.MayTinhRepository
import kotlinx.coroutines.launch

class MayTinhViewModel(private val repository: MayTinhRepository) : ViewModel() {
    val allMayTinh = repository.allMayTinh

    fun insert(mayTinh: MayTinh) = viewModelScope.launch {
        repository.insert(mayTinh)
    }

    fun update(mayTinh: MayTinh) = viewModelScope.launch {
        repository.update(mayTinh)
    }

    fun delete(mayTinh: MayTinh) = viewModelScope.launch {
        repository.delete(mayTinh)
    }
}

