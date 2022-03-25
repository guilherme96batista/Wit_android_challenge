package pt.guilhermerodrigues.wit_android_challenge.views

import androidx.lifecycle.ViewModel
import pt.guilhermerodrigues.wit_android_challenge.models.City

class HomeViewModel : ViewModel() {
    val cities = mutableListOf<City>()

    init {
        loadCities()
    }

    private fun loadCities(){
        //get the cities from the openweather service

        cities.add(City("London", "cold"))
        cities.add(City("Paris", "hot"))
        cities.add(City("Madrid", "hot"))
    }


}
