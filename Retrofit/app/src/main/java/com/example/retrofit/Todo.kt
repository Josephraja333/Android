package com.example.retrofit

data class Todo(
    var completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)