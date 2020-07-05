package com.ardyyy.dev.androidmvvm.data.models.response


import com.ardyyy.dev.androidmvvm.data.local.entity.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UsersData(
    @Json(name = "per_page")
    val perPage: Int = 0,
    @Json(name = "total")
    val total: Int = 0,
    @Json(name = "data")
    val data: List<User>? = null,
    @Json(name = "page")
    val page: Int = 0,
    @Json(name = "total_pages")
    val totalPages: Int = 0
)


