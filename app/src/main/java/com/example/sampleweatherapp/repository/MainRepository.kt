package com.example.sampleweatherapp.repository

import com.example.sampleweatherapp.data.webservice.WebService

class MainRepository(private val webService: WebService) {

    suspend fun getWeatherDetail(city: String) = webService.getWeatherDetail(city)

}