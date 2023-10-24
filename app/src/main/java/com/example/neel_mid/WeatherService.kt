package com.example.neel_mid

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {


    @GET("timeline/{city}")
    suspend fun getWeather(@Path("city") city: String, @Query("key") apiKey: String): WeatherData

    companion object {
        private const val BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/"
        const val API_KEY = "BNR9A4ND6HNMB3WX2RTE7R63Q"

        fun create(): WeatherService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(WeatherService::class.java)
        }
    }
}

