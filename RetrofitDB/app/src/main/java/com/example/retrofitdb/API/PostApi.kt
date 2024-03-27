package com.example.retrofitdb.API

import com.example.retrofitdb.Database.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    suspend fun getPost(): Response<List<Posts>>
}