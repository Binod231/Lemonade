package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemoadeApp()
        }
    }
}
@Preview
@Composable
fun LemoadeApp(){
LemonadeDrinks()
}


@Composable
fun LemonadeDrinks(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree to R.string.lemon_tree
        2 -> R.drawable.lemon_squeeze to R.string.lemon_squeeze
        3 -> R.drawable.lemon_squeeze to R.string.lemon_squeeze
        4 -> R.drawable.lemon_squeeze to R.string.lemon_squeeze
        5 -> R.drawable.lemon_drink to R.string.lemon_drink
        else -> R.drawable.lemon_restart to R.string.lemon_restart


    }
    val lightSkyBlue = Color(0x5087CEEB)
    Column(modifier = Modifier.fillMaxSize()
        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Yellow)
                .height(55.dp)
            //horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(R.string.lemonade),
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )


        }
        Column(
            modifier = Modifier
                .fillMaxSize()

                .background(color = lightSkyBlue),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Button(onClick = { result = (result % 6) + 1 }) {
                Image(
                    painter = painterResource(id = imageResource.first),
                    contentDescription = result.toString()
                )

            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = imageResource.second),
                fontSize = 20.sp
            )
        }

    }
}