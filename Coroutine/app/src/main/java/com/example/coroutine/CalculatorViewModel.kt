package com.example.coroutine
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalculatorViewModel : ViewModel() {

    private val _result = MutableLiveData<Int>()
    val result: LiveData<Int> get() = _result

    fun calculateSum(a: Int, b: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _result.postValue(a + b)
        }
    }

    fun calculateDifference(a: Int, b: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _result.postValue(a - b)
        }
    }
}
