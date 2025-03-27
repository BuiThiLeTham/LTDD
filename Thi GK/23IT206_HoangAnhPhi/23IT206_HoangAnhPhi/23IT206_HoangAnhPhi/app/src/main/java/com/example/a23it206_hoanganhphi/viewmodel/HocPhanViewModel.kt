package com.example.a23it206_hoanganhphi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.a23it206_hoanganhphi.data.AppDatabase
import com.example.a23it206_hoanganhphi.data.HocPhan
import com.example.a23it206_hoanganhphi.data.HocPhanDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HocPhanViewModel(application: Application) : AndroidViewModel(application) {
    
    private val hocPhanDao: HocPhanDao
    val allHocPhan: LiveData<List<HocPhan>>
    
    init {
        val database = AppDatabase.getDatabase(application)
        hocPhanDao = database.hocPhanDao()
        allHocPhan = hocPhanDao.getAllHocPhan()
    }
    
    fun insert(hocPhan: HocPhan) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val id = hocPhanDao.insert(hocPhan)
                println("Học phần đã được lưu với ID: $id")
            } catch (e: Exception) {
                println("Lỗi khi lưu học phần: ${e.message}")
                e.printStackTrace()
            }
        }
    }
    
    fun update(hocPhan: HocPhan) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                hocPhanDao.update(hocPhan)
                println("Học phần ID: ${hocPhan.mahocphan} đã được cập nhật")
            } catch (e: Exception) {
                println("Lỗi khi cập nhật học phần: ${e.message}")
                e.printStackTrace()
            }
        }
    }
    
    fun delete(hocPhan: HocPhan) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                hocPhanDao.delete(hocPhan)
                println("Học phần ID: ${hocPhan.mahocphan} đã được xóa")
            } catch (e: Exception) {
                println("Lỗi khi xóa học phần: ${e.message}")
                e.printStackTrace()
            }
        }
    }
    
    fun getHocPhanByHocKy(hocky: String): LiveData<List<HocPhan>> {
        return hocPhanDao.getHocPhanByHocKy(hocky)
    }
    
    // Function to sum two real numbers
    fun sumTwoNumbers(num1: Double, num2: Double): Double {
        return num1 + num2
    }
}
