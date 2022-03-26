package pt.guilhermerodrigues.wit_android_challenge.views

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import pt.guilhermerodrigues.wit_android_challenge.models.City
import pt.guilhermerodrigues.wit_android_challenge.models.Weather
import pt.guilhermerodrigues.wit_android_challenge.services.WeatherService

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    val cities = mutableListOf<City>()
    val weatherService = WeatherService(context)

    init {
        loadCities()
        weatherService.getWeather("Coimbra")
    }

    private fun loadCities(){
        //get the cities from the openweather service

        cities.add(City("London", "cold",null))
        cities.add(City("Paris", "hot",null))
        cities.add(City("Madrid", "hot",null))
    }


}
