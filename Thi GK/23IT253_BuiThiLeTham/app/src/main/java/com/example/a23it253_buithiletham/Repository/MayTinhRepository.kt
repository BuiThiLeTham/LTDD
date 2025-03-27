package com.example.a23it253_buithiletham.Repository

import androidx.lifecycle.LiveData
import com.example.a23it253_buithiletham.DAO.MayTinhDao
import com.example.a23it253_buithiletham.Entity.MayTinh

class MayTinhRepository(private val mayTinhDao: MayTinhDao) {
    val allMayTinh: LiveData<List<MayTinh>> = mayTinhDao.getAllMayTinh()

    suspend fun insert(mayTinh: MayTinh) {
        mayTinhDao.insert(mayTinh)
    }

    suspend fun update(mayTinh: MayTinh) {
        mayTinhDao.update(mayTinh)
    }

    suspend fun delete(mayTinh: MayTinh) {
        mayTinhDao.delete(mayTinh)
    }
}