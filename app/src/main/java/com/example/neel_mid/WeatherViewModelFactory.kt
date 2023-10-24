package com.example.neel_mid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.neel_mid.WeatherService
import com.example.neel_mid.WeatherViewModel


class WeatherViewModelFactory(private val weatherService: WeatherService) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(weatherService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}






