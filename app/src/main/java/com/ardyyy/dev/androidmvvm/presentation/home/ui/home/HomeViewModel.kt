package com.ardyyy.dev.androidmvvm.presentation.home.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ardyyy.dev.androidmvvm.data.models.response.UsersData
import com.ardyyy.dev.androidmvvm.data.repository.UsersRepository
import com.ardyyy.dev.androidmvvm.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val usersRepository: UsersRepository
) : ViewModel() {

    val usersData = MutableLiveData<UiState<UsersData>>()

    fun getUsersData() {
        //1. loading
        //2. ambil dari db, kalo gak kosong emit, kalo kosng do nothing
        //3. hit api, simpan ke db
        //4. refresh ambil dari db & emit resuorce
        usersData.value = UiState.Loading()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                fetchLocal()

                val result = usersRepository.getUsersData()
                result.apply {
                    if (data != null) {
                        if (data.isNotEmpty()) {
                            data.let { usersRepository.insertAllUser(it) }
                            fetchLocal()
                        }
                    }
                }
            } catch (e: Exception) {
                usersData.postValue(UiState.Error(e))
            }
        }
    }

    private fun fetchLocal() {
        val tempLocal = usersRepository.getAllUser()
        usersData.postValue(UiState.Success(UsersData(data = tempLocal)))
    }

}