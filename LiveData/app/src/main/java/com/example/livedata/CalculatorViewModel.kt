package com.example.livedata

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val _sumResult = MutableLiveData<Int>()
    val sumResult: LiveData<Int> get() = _sumResult

    private val _differenceResult = MutableLiveData<Int>()
    val differenceResult: LiveData<Int> get() = _differenceResult

    fun calculateSum(a: Int, b: Int) {
        _sumResult.value = a + b
    }

    fun calculateDifference(a: Int, b: Int) {
        _differenceResult.value = a - b
    }
}
