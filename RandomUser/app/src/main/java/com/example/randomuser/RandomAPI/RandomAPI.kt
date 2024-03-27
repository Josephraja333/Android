package com.example.randomuser.RandomAPI

import retrofit2.Response
import retrofit2.http.GET

interface RandomAPI {
    @GET("?results=25")
    suspend fun getRandom(): Response<RandomData>
}