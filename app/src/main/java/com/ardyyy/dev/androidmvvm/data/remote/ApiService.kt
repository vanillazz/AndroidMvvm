package com.ardyyy.dev.androidmvvm.data.remote

import com.ardyyy.dev.androidmvvm.data.models.response.UsersData
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsersData(): UsersData
}