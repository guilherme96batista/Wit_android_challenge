package pt.guilhermerodrigues.wit_android_challenge.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import pt.guilhermerodrigues.wit_android_challenge.Routes
import pt.guilhermerodrigues.wit_android_challenge.components.CityCard
import pt.guilhermerodrigues.wit_android_challenge.models.City


@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavController
){
    LazyColumn(

    ){
        item {
            CityCard(city = viewModel.myCity.value, onClick = {
                    navController.navigate(Routes.cityDetails(-1))
            })
        }
        //items() is for items which you don't need the index
        itemsIndexed(
            items = viewModel.cities
        ){ index, city ->
            city?.let {
                CityCard(city = it, onClick = {
                navController.navigate(Routes.cityDetails(index))
                })
            }
        }
    }
}
