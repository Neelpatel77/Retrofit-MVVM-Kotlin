package com.example.neel_mid

data class WeatherData(
    val resolvedAddress: String,
    val currentConditions: CurrentConditions,
    val days: List<Day>,
    val description: String,
    val timezone: String,
)

data class CurrentConditions(
    val datetime: String,
    val temp: Double,
)

data class Day(
    val datetime: String,
    val temp: Double,
    val tempmax: Double,
    val tempmin: Double,
    val description: String,
    val conditions: String,
    val precipprob: Double,
)
