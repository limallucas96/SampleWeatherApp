package com.example.sampleweatherapp.data.webservice

import com.example.sampleweatherapp.data.entities.WeatherEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("weather")
    suspend fun getWeatherDetail(@Query("q") city: String, @Query("appid") appId: String = API_KEY): Response<WeatherEntity>

    companion object {
        const val API_KEY = "9a15af44e1ee6d7736312d77df4c1c95"
    }
}