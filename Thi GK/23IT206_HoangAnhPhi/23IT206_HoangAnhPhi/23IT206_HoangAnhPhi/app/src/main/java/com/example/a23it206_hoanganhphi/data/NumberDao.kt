package com.example.a23it206_hoanganhphi.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NumberDao {
    @Insert
    suspend fun insert(numberEntity: NumberEntity)
    
    @Query("SELECT * FROM number_history ORDER BY timestamp DESC")
    fun getAllNumbers(): LiveData<List<NumberEntity>>
}
