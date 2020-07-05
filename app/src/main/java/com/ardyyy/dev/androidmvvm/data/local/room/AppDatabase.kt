package com.ardyyy.dev.androidmvvm.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ardyyy.dev.androidmvvm.data.local.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "testapp_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

            }
            return INSTANCE!!
        }
    }

    abstract fun userDao(): AppDao
}