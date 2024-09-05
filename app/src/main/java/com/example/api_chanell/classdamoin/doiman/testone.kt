package com.example.api_chanell.classdamoin.doiman


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class testone(
    @SerialName("results")
    val results: Results,
    @SerialName("status")
    val status: String
)