package pt.guilhermerodrigues.wit_android_challenge

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pt.guilhermerodrigues.wit_android_challenge.models.City
import pt.guilhermerodrigues.wit_android_challenge.views.CityDetails
import pt.guilhermerodrigues.wit_android_challenge.views.HomeScreen
import pt.guilhermerodrigues.wit_android_challenge.views.HomeViewModel

object Routes {
    const val Home = "home"
    const val CityDetails = "city_details/{cityIndex}"

    fun cityDetails(cityIndex: Int) = "city_details/$cityIndex"

}

@Preview
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel: HomeViewModel = viewModel(LocalContext.current as ComponentActivity)


    NavHost(
        navController = navController,
        startDestination = Routes.Home,
        modifier = Modifier.background(MaterialTheme.colors.background),
    ) {
        composable(Routes.Home) {
            HomeScreen(viewModel = viewModel, navController = navController)
        }

        composable(
            Routes.CityDetails,
            arguments = listOf(navArgument("cityIndex"){type = NavType.IntType})
        ) {backStackEntry ->
        val cityId = backStackEntry.arguments!!.getInt("cityIndex")
            CityDetails(
                viewModel = viewModel,
                navController = navController,
                index = cityId,
            )
        }
    }
}