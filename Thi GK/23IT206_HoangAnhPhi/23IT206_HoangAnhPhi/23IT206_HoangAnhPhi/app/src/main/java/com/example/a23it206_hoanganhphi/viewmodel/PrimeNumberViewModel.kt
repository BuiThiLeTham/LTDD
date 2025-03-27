package com.example.a23it206_hoanganhphi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.a23it206_hoanganhphi.data.AppDatabase
import com.example.a23it206_hoanganhphi.data.NumberDao
import com.example.a23it206_hoanganhphi.data.NumberEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.sqrt

class PrimeNumberViewModel(application: Application) : AndroidViewModel(application) {
    
    private val numberDao: NumberDao
    val allNumbers: LiveData<List<NumberEntity>>
    
    init {
        val database = AppDatabase.getDatabase(application)
        numberDao = database.numberDao()
        allNumbers = numberDao.getAllNumbers()
    }
    
    fun insertNumber(numberEntity: NumberEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            numberDao.insert(numberEntity)
        }
    }
    
    fun isPrimeNumber(number: Long): Boolean {
        if (number < 1) return false
        if (number == 2L || number == 3L) return true
        if (number % 2 == 0L || number % 3 == 0L) return false
        
        val sqrtN = sqrt(number.toDouble()).toLong()
        var i = 5L
        while (i <= sqrtN) {
            if (number % i == 0L || number % (i + 2) == 0L) return false
            i += 6
        }
        
        return true
    }
}
