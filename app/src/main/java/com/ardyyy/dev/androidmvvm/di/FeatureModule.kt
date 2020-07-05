package com.ardyyy.dev.androidmvvm.di

import com.ardyyy.dev.androidmvvm.data.repository.UsersRepository
import org.koin.dsl.module

val featureModule = module {
    single { UsersRepository(get(), get()) }
}