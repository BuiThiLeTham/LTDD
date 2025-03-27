package com.example.a23it235_buithiletham.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.a23it253_buithiletham.Entity.MayTinh
import kotlinx.coroutines.flow.Flow

@Dao
interface MayTinhDao {
    @Insert
    suspend fun insert(mayTinh: MayTinh)

    @Update
    suspend fun update(mayTinh: MayTinh)

    @Delete
    suspend fun delete(mayTinh: MayTinh)

    @Query("SELECT * FROM may_tinh ORDER BY tenmay ASC")
    fun getAllMayTinh(): LiveData<List<MayTinh>>
}