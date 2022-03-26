package pt.guilhermerodrigues.wit_android_challenge.services

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import pt.guilhermerodrigues.wit_android_challenge.models.City
import pt.guilhermerodrigues.wit_android_challenge.models.Weather


//write a service to fetch the weather data from openweather api
class WeatherService (context : Context) {

    private val requestQueue = Volley.newRequestQueue(context)
    private val BASE_URL = "https://api.openweathermap.org/data/2.5/weather?"
    private val API_KEY = "a33be2e8f8e24251537b2ed2d62e5de0"

    // for metric system https://api.openweathermap.org/data/2.5/weather?lat=57&lon=-2.15&appid={API key}&units=metric
    // for calling by city name https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}


   /* receive the openweather json String response "result" and get the weather list
    val result = "result"

    fun jsonToMap(str: String?): MutableMap<String?, Any?>? {
        return Gson().fromJson(str, object : TypeToken<HashMap<String?, Any?>?>() {}.type)
    }

    var respMap: MutableMap<String?, Any?>? = jsonToMap(result.toString())
    var weather = respMap?.get("weather") as List<Map<String, Any>>
    */

    fun getWeather(city : City){
        val url = BASE_URL + "q=" + city.designation + "&appid=" + API_KEY + "&units=metric"

        val stringRequest = StringRequest(Request.Method.POST, url,
            { response ->
                Log.d("response", response)
                //parse the json
                val weather = Gson().fromJson(response, Weather::class.java)
                city.weather = weather

            },
            null)

        requestQueue.add(stringRequest)

    }

    fun getWeatherByCoord(lat : Double, lon : Double) : City{
        val url = BASE_URL + "lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY + "&units=metric"

        val stringRequest = StringRequest(Request.Method.POST, url,
            { response ->
                Log.d("response", response)
                //parse the json
                val weather = Gson().fromJson(response, Weather::class.java)
                //city.weather = weather

            },
            null)

        requestQueue.add(stringRequest)


        //get the name of the city and other information from Json
        return City("",null, null, null)
    }
}