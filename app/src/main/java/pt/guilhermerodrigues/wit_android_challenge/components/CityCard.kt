package pt.guilhermerodrigues.wit_android_challenge.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import pt.guilhermerodrigues.wit_android_challenge.models.City

@Composable
fun CityCard(
    city : City,
    onClick : () -> Unit,
){
    city.designation?.let { designation ->
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable(onClick = onClick)
            .background(White)

    ){
        Column(modifier = Modifier
            .background(White)
        ) {
            //images
            //rows…
            Row(
                modifier = Modifier
                    .padding(
                        bottom = 6.dp,
                        top = 6.dp
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colors.surface)
                    .fillMaxWidth(),
                ) {
                Box(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .clip(RoundedCornerShape(8.dp))
                        //.size(72.dp)
                ) {
                   SubcomposeAsyncImage(
                       model = "http://openweathermap.org/img/wn/10d@2x.png",
                       loading = {
                           CircularProgressIndicator()
                       },
                       contentDescription = null,

                   )

                }
                Column {
                    Row() {
                        Column{
                            Text(
                                text = designation,
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.padding(start = 20.dp)
                            )
                        }
                            Column{
                                Text(
                                    text = city.main?.temp.toString() + "ºC",
                                    style = MaterialTheme.typography.h6,
                                    //modifier = Modifier.padding(start = 20.dp),
                                    textAlign = TextAlign.Right
                                )
                            }
                    }
                    Row() {
                        Text(
                            text = city.weather?.main.toString(),
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }

                }

            }
        }
    }
}