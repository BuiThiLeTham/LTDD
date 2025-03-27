package com.example.a23it253_buithiletham.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "may_tinh")
data class MayTinh(
    @PrimaryKey(autoGenerate = true)
    val mamay: Int = 0,
    val tenmay: String,
    val loaimay: String,
    val soluong: Int,
    val dongia: Double
) {
    fun thanhTien(): Double = soluong * dongia
}