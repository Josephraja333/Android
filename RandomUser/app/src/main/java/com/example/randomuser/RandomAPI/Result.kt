package com.example.randomuser.RandomAPI

import com.google.gson.annotations.SerializedName

data class RandomData(
    @SerializedName("results")
    val results: List<Result>
)

data class Result(
    @SerializedName("name")
    val name: Name,

    @SerializedName("location")
    val location: Location,

    @SerializedName("email")
    val email: String,

    @SerializedName("dob")
    val dob: Dob,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("picture")
    val picture: Picture,
)

data class Name(
    @SerializedName("first")
    val first: String,

    @SerializedName("last")
    val last: String
)

data class Location(
    @SerializedName("country")
    val country: String
)

data class Dob(
    @SerializedName("date")
    val date: String,
)

data class Picture(
    @SerializedName("large")
    val large: String
)

