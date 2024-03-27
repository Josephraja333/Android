package com.example.retrofitdb.Database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface PostDatabaseDAO {
    @Upsert
    suspend fun insert(userData: Post)

    @Query("SELECT userID FROM post")
    fun getUserID():Int

    @Query("SELECT id FROM post")
    fun getID():Int

    @Query("SELECT title FROM post")
    fun getTitle():List<String>

    @Query("SELECT body FROM post")
    fun getBody():String

    @Query("DELETE FROM post")
    fun clear()
}