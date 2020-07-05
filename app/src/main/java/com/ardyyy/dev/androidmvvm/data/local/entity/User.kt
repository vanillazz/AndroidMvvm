package com.ardyyy.dev.androidmvvm.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class User(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @Json(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "first_name")
    @Json(name = "first_name")
    val firstName: String? = null,

    @ColumnInfo(name = "last_name")
    @Json(name = "last_name")
    val lastName: String? = null,

    @ColumnInfo(name = "avatar")
    @Json(name = "avatar")
    val avatar: String? = null,

    @ColumnInfo(name = "email")
    @Json(name = "email")
    val email: String? = null

) : Parcelable