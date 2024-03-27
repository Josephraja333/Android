package com.example.roomdata.Database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface FormDatabaseDAO {
    @Upsert
    fun insert(userData: Form)

    @Query("SELECT name FROM forms")
    fun getName():String

    @Query("SELECT email FROM forms")
    fun getEmail():String

    @Query("SELECT age FROM forms")
    fun getAge():Int

    @Query("SELECT gender FROM forms")
    fun getGender():String

    @Query("DELETE FROM forms")
    fun clear()

}