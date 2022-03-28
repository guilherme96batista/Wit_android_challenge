package pt.guilhermerodrigues.wit_android_challenge.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import pt.guilhermerodrigues.wit_android_challenge.models.City

@Composable
fun CityDetails(
    viewModel: HomeViewModel,
    navController : NavController,
    index : Int,
){
    lateinit var city : City
    if(index == -1)
       city = viewModel.myCity.value
    else
       city = viewModel.cities.value[index]

    Scaffold(
        topBar = {},
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xCED6D0)),

        ) {
            Box(modifier = Modifier         // metade superior = imagem
                .clip(RoundedCornerShape(12.dp))
                .padding(8.dp)
                //.background(Black)
                .weight(1f)
                .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            )  {
                SubcomposeAsyncImage(
                    model = "http://openweathermap.org/img/wn/10d@2x.png",
                    loading = {
                        CircularProgressIndicator()
                    },
                    contentDescription = null,
                    )
            }
            Column(modifier = Modifier         // metade inferior = info
                .padding(24.dp)
                .weight(2f)
                .fillMaxWidth(),
                //contentAlignment = Alignment.Center

            ){
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    ){
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                    ) {
                        Column(modifier = Modifier
                            .weight(1f)
                        ) {
                            Text(
                                text = "Min: ${city.main?.temp_min} ºC",
                                style = MaterialTheme.typography.h6,
                                color = Black
                            )
                        }
                        Column(modifier = Modifier
                            .weight(2f)
                        ) {
                            Text(
                                modifier = Modifier.padding(
                                    start = 20.dp),
                                text = "${city.main?.temp }ºC",
                                style = MaterialTheme.typography.h4,
                                color = Black,

                            )
                        }
                        Column(modifier = Modifier
                            .weight(1f)
                        ) {
                            Text(
                                text = "Max: ${city.main?.temp_max} ºC",
                                style = MaterialTheme.typography.h6,
                                color = Black
                            )
                        }
                    }
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    ){
                    Column() {
                        Text(
                            text = city.weather?.description.toString(),
                            color = Black,
                            style = MaterialTheme.typography.h4
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                    ){
                    Row() {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "${city.main?.humidity}%",
                                style = MaterialTheme.typography.h6,
                                color = Black
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "${city.wind?.speed}Km/h",
                                style = MaterialTheme.typography.h6,
                                color = Black
                            )
                        }
                    }


                }

            }
        }
    }
}