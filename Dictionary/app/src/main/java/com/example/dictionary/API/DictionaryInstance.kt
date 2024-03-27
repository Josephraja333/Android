package com.example.dictionary.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DictionaryInstance {
    val api: DictionaryApi by lazy {
        Retrofit.Builder().baseUrl("https://api.dictionaryapi.dev/api/v2/entries/").addConverterFactory(GsonConverterFactory.create()).build().create(DictionaryApi::class.java)
    }
}