package com.ardyyy.dev.androidmvvm.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ardyyy.dev.androidmvvm.data.repository.UsersRepository
import com.ardyyy.dev.androidmvvm.presentation.ui.home.HomeViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock


class HomeViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var homeViewModel: HomeViewModel
    private val usersRepository = mock(UsersRepository::class.java)

    @Before
    fun before() {
        homeViewModel = HomeViewModel(usersRepository)
    }

    @Test
    fun getUserData() {
        homeViewModel.getUsersData()
        Assert.assertNotNull(homeViewModel.usersData.value)
    }
}