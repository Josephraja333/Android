package com.example.retrofitdb.API

data class Posts(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)