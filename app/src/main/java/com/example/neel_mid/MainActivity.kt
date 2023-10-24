package com.example.neel_mid





import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, WeatherViewModelFactory(WeatherService.create()))
            .get(WeatherViewModel::class.java)

        val cityEditText = findViewById<EditText>(R.id.cityEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val temperatureTextView = findViewById<TextView>(R.id.temperatureTextView)
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)

        submitButton.setOnClickListener {
            val city = cityEditText.text.toString()
            if (city.isNotEmpty()) {
                viewModel.getWeather(city)
            } else {
                Toast.makeText(this, "Please enter a city", Toast.LENGTH_SHORT).show()
            }
        }


        viewModel.weatherData.observe(this, Observer { weatherData ->
            weatherData?.let {
                val details = "City: ${it.resolvedAddress}\n" +
                        "Current Temperature: ${it.currentConditions.temp} F\n" +
                        "Today's Maximum Temperature: ${it.days[0].tempmax}F\n" +
                        "Today's Minimum Temperature: ${it.days[0].tempmin}F\n" +
                        "Probability of Precipitation (POP): ${it.days[0].precipprob}\n" +
                        "Description: ${it.description}"

                temperatureTextView.text = details
                descriptionTextView.text = ""
            }
        })
    }
}
