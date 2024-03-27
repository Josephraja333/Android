package com.example.retrofitdb.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class Post(
    @ColumnInfo("userID")
    var userid: Int = 1,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    var id: Int = 0,
    @ColumnInfo("title")
    var title: String,
    @ColumnInfo("body")
    var body: String
)