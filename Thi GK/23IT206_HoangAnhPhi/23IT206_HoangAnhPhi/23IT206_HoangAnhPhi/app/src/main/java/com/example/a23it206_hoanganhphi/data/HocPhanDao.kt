package com.example.a23it206_hoanganhphi.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HocPhanDao {
    @Insert
    suspend fun insert(hocPhan: HocPhan): Long
    
    @Update
    suspend fun update(hocPhan: HocPhan)
    
    @Delete
    suspend fun delete(hocPhan: HocPhan)
    
    @Query("SELECT * FROM hoc_phan ORDER BY tenhocphan ASC")
    fun getAllHocPhan(): LiveData<List<HocPhan>>
    
    @Query("SELECT * FROM hoc_phan WHERE hocky = :hocky")
    fun getHocPhanByHocKy(hocky: String): LiveData<List<HocPhan>>
}
