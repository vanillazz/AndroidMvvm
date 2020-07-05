package com.ardyyy.dev.androidmvvm.data.repository

import com.ardyyy.dev.androidmvvm.data.local.entity.User
import com.ardyyy.dev.androidmvvm.data.local.room.AppDao
import com.ardyyy.dev.androidmvvm.data.remote.ApiService

class UsersRepository(private val dao: AppDao, private val apiService: ApiService) {

    fun getAllUser() = dao.getAllUser()
    fun insertAllUser(users: List<User>) = dao.insertAll(users)

    suspend fun getUsersData() = apiService.getUsersData()
}