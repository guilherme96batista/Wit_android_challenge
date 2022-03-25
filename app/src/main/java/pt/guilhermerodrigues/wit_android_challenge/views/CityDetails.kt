package pt.guilhermerodrigues.wit_android_challenge.views

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import pt.guilhermerodrigues.wit_android_challenge.models.City

@Composable
fun CityDetails(
    viewModel: HomeViewModel,
    navController : NavController,
    index : Int,
){
    val city = viewModel.cities[index]
    Scaffold(
        topBar = {},
    ){
        //insert a card for the detailed view of the city weather
    }


}