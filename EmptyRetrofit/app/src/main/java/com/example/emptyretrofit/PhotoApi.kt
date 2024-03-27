package com.example.emptyretrofit

import retrofit2.Response
import retrofit2.http.GET

interface PhotoApi {

    @GET("/photos")
    suspend fun getPhotos(): Response<List<Photo>>
}