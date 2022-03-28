package pt.guilhermerodrigues.wit_android_challenge.views

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import pt.guilhermerodrigues.wit_android_challenge.models.City
import pt.guilhermerodrigues.wit_android_challenge.services.WeatherService

@SuppressLint("MissingPermission")
class HomeViewModel(application: Application) : AndroidViewModel(application) {

    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext
    val myCity = mutableStateOf(City("waiting for your location", null, null, null))
    val cities = mutableStateOf(ArrayList<City>())
    @SuppressLint("MutableCollectionMutableState")
    val weatherService = WeatherService(context)


    private var currentLocation: Location? = null
    lateinit var locationManager: LocationManager



    init {
        gps()
        initCities()
        loadCities()
    }
    private fun initCities(){
        cities.value.add(City("Lisboa", null, null, null))
        cities.value.add(City("Madrid", null, null, null))
        cities.value.add(City("Paris", null, null, null))
        cities.value.add(City("Berlin", null, null, null))
        cities.value.add(City("Copenhagen", null, null, null))
        cities.value.add(City("Roma", null, null, null))
        cities.value.add(City("London", null, null, null))
        cities.value.add(City("Dublin", null, null, null))
        cities.value.add(City("Prague", null, null, null))
        cities.value.add(City("Vienna", null, null, null))
    }

    private fun loadCities(){
        for (city in cities.value){
            weatherService.getWeather(city)
        }
    }

    private fun gps(){
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        val gpsLocationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                currentLocation = location
                currentLocation?.let {
                    if(myCity.value.designation == "waiting for your location") {
                        weatherService.getWeatherByCoord(currentLocation!!.latitude, currentLocation!!.longitude, myCity)
                    }
                }
            }
            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle) {
            }
        }
        if (hasGps) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                50, 0f, gpsLocationListener)
        }
    }


}
