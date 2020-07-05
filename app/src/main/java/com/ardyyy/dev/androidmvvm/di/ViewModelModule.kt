package com.ardyyy.dev.androidmvvm.di

import com.ardyyy.dev.androidmvvm.presentation.home.ui.home.HomeViewModel
import com.ardyyy.dev.androidmvvm.presentation.home.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
}