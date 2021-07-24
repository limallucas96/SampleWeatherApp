package com.example.sampleweatherapp.data.entities

import java.io.Serializable

data class WeatherEntity(
    val coord: Coord? = null,
    val weather: List<Weather>? = null,
    val main: Main? = null,
    val name: String? = null,
) : Serializable

data class Coord(
    val lon: Double? = null,
    val lat: Double? = null
) : Serializable

data class Main(
    val temp: Double? = null,
    val feelsLike: Double? = null,
    val tempMin: Double? = null,
    val tempMax: Double? = null,
    val pressure: Long? = null,
    val humidity: Long? = null
) : Serializable

data class Weather(
    val id: Long? = null,
    val main: String? = null,
    val description: String? = null,
    val icon: String? = null
) : Serializable
