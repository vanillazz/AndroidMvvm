package com.ardyyy.dev.androidmvvm.data.local.room

import androidx.room.*
import com.ardyyy.dev.androidmvvm.data.local.entity.User

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(user: List<User>)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("DELETE FROM user")
    fun deleteAll()

    @Query("SELECT * from user ORDER BY id ASC")
    fun getAllUser(): List<User>

    @Query("SELECT * from user WHERE id = :userId")
    fun getUserById(userId: Int): User
}