package pt.guilhermerodrigues.wit_android_challenge.models

data class City (
    val designation : String?,
    var main : Main?,
    var weather : Weather?,
    var wind : Wind?,
    )

data class Main(
    val temp: Double?,
    val feels_like: Double?,
    val temp_min: Double?,
    val temp_max: Double?,
    val pressure: Double?,
    val humidity: Double?,
)

data class Weather(
    val id: Int?,
    val main: String?,
    val description: String?,
    val icon: String?
)

data class Wind(
    val speed: Double?,
    val deg: Double?
)
