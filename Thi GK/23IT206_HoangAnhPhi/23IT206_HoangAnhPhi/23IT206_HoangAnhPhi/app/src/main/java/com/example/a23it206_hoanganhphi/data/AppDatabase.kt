package com.example.a23it206_hoanganhphi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [NumberEntity::class, HocPhan::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun numberDao(): NumberDao
    abstract fun hocPhanDao(): HocPhanDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                .fallbackToDestructiveMigration() // Handle version changes
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
