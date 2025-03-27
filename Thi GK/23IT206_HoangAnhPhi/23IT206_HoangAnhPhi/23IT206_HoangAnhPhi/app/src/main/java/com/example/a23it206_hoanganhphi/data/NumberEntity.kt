package com.example.a23it206_hoanganhphi.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "number_history")
data class NumberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val number: Long,
    val isPrime: Boolean,
    val timestamp: Date
)
