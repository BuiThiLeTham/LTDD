package com.example.a23it253_buithiletham.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a23it235_buithiletham.DAO.MayTinhDao

import com.example.a23it253_buithiletham.Entity.MayTinh

@Database(entities = [MayTinh::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mayTinhDao(): MayTinhDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "may_tinh_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}