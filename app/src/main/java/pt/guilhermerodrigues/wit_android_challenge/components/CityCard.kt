package pt.guilhermerodrigues.wit_android_challenge.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pt.guilhermerodrigues.wit_android_challenge.models.City

@Composable
fun CityCard(
    city : City,
    onClick : () -> Unit,
){
    Card(
        modifier = Modifier
            .padding()
            .clickable(onClick = onClick)

    ){
        Column() {
            //images
            //rows…
            Row(modifier = Modifier.padding(top = 16.dp)) {
                city.designation?.let { designation ->
                    Text(text = designation)
                }
            }
            /*Row(modifier = Modifier.padding(top = 16.dp)) {
                city.weather?.let { weather ->
                    Text(text = weather)
                }
            }*/
            //etc
        }
    }
}