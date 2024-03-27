package com.example.randomuser.WeatherApi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("/v1/current.json?key=01037f0b0ac54c50b0050649243001&aqi=yes")
    suspend fun getWeather(@Query("q") q : String): Response<WeatherData>
}