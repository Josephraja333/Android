package com.example.randomuser.WeatherApi

import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("current")
    val data : Current
)

data class Current(
    @SerializedName("condition")
    val condition : Condition,
    @SerializedName("air_quality")
    val aq : AirQuality,
    @SerializedName("temp_c")
    val cel : Double
)

data class Condition(
    @SerializedName("text")
    val text : String,
    @SerializedName("icon")
    val icon : String
)

data class AirQuality(
    @SerializedName("us-epa-index")
    val index : Int
)

