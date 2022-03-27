package pt.guilhermerodrigues.wit_android_challenge.views

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import pt.guilhermerodrigues.wit_android_challenge.models.City
import pt.guilhermerodrigues.wit_android_challenge.models.Weather
import pt.guilhermerodrigues.wit_android_challenge.services.LocationService
import pt.guilhermerodrigues.wit_android_challenge.services.WeatherService

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    var myCity = City(null, null, null, null)
    val cities = mutableListOf<City>()
    val weatherService = WeatherService(context)
    //val coords = LocationService(context).getLocation()

    init {
        //myCity = weatherService.getWeatherByCoord(coords.latitude, coords.longitude)
        initCities()
        loadCities()
    }
    private fun initCities(){
        cities.add(City("Lisboa", null, null, null))
        cities.add(City("Madrid", null, null, null))
        cities.add(City("Paris", null, null, null))
        cities.add(City("Berlin", null, null, null))
        cities.add(City("Copenhagen", null, null, null))
        cities.add(City("Roma", null, null, null))
        cities.add(City("London", null, null, null))
        cities.add(City("Dublin", null, null, null))
        cities.add(City("Prague", null, null, null))
        cities.add(City("Vienna", null, null, null))
    }

    private fun loadCities(){
        for (city in cities){
            weatherService.getWeather(city)
        }
    }


}
