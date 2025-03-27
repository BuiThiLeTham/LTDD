package com.example.a23it206_hoanganhphi.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hoc_phan")
data class HocPhan(
    @PrimaryKey(autoGenerate = true)
    val mahocphan: Long = 0,
    val tenhocphan: String,
    val sotinchi: Int,
    val hocky: String
)
