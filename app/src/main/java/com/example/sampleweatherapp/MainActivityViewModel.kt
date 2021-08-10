package com.example.sampleweatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleweatherapp.data.entities.WeatherEntity
import com.example.sampleweatherapp.data.webservice.WebService
import com.example.sampleweatherapp.repository.MainRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(private val MainRepository: MainRepository) : ViewModel() {

    private val weatherMutableLiveData = MutableLiveData<WeatherEntity>()

    val weatherLiveData: LiveData<WeatherEntity>
        get() = weatherMutableLiveData

    fun getWeatherDetail(city: String) {
        viewModelScope.launch {
            val result = MainRepository.getWeatherDetail(city).body()
            weatherMutableLiveData.postValue(result)
        }
    }

}