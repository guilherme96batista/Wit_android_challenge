package pt.guilhermerodrigues.wit_android_challenge.models

data class City (
    val designation : String?,
    val weather : String?
    )


data class Weather (
    val id : Int?,
    val temperature : String?,
    val humidity : String?,
    val wind : String?
    )