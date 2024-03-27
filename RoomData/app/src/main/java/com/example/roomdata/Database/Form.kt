package com.example.roomdata.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "forms")
data class Form (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("ID")
    var id: Int = 1,
    @ColumnInfo("name")
    var name: String,
    @ColumnInfo("email")
    var email: String,
    @ColumnInfo("gender")
    var gender: String,
    @ColumnInfo("age")
    var age: Int
)