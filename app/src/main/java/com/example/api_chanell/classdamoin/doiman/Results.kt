package com.example.api_chanell.classdamoin.doiman


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Results(
    @SerialName("date")
    val date: String,
    @SerialName("dawn")
    val dawn: String,
    @SerialName("day_length")
    val dayLength: String,
    @SerialName("dusk")
    val dusk: String,
    @SerialName("first_light")
    val firstLight: String,
    @SerialName("golden_hour")
    val goldenHour: String,
    @SerialName("last_light")
    val lastLight: String,
    @SerialName("solar_noon")
    val solarNoon: String,
    @SerialName("sunrise")
    val sunrise: String,
    @SerialName("sunset")
    val sunset: String,
    @SerialName("timezone")
    val timezone: String,
    @SerialName("utc_offset")
    val utcOffset: Int
)