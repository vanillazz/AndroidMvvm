package com.ardyyy.dev.androidmvvm.di

import com.ardyyy.dev.androidmvvm.data.local.room.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {

    single { AppDatabase.getDatabase(androidContext()) }

    single {
        val database: AppDatabase = get()
        return@single database.userDao()
    }
}