package com.example.randomuser.RandomAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRandomInstance {
    val api: RandomAPI by lazy {
        Retrofit.Builder().baseUrl("https://randomuser.me/api/").addConverterFactory(
            GsonConverterFactory.create()).build().create(RandomAPI::class.java)
    }
}