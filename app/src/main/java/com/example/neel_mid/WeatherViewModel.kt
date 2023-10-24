package com.example.neel_mid


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
 import kotlinx.coroutines.launch

class WeatherViewModel(private val weatherService: WeatherService) : ViewModel() {

    private val _weatherData = MutableLiveData<WeatherData?>()
    val weatherData: LiveData<WeatherData?>
        get() = _weatherData


    fun getWeather(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = weatherService.getWeather(city, WeatherService.API_KEY)
                _weatherData.postValue(response)
            } catch (e: Exception) {
                _weatherData.postValue(null)
            }
        }
    }



}

