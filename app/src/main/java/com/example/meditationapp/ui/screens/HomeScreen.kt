package com.example.meditationapp.ui.screens

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditationapp.*
import com.example.meditationapp.R

@Composable
fun  HomeScreen() {
    Box(modifier =  Modifier.background(color  = DeepBlue )){
        Column {
            GreetingSection()
            ChipSection(chips =  listOf("House", "Name", "Place"))
        }
    }

}

@Composable
fun ChipSection(chips : List<String> ) {
    var selectedIndex by  remember  {
    mutableStateOf(0)
    }
    LazyRow( ){
        items(chips.size) {
            var isSelecteed: Boolean  = selectedIndex == it
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                        .clickable {
                            selectedIndex = it
                        }
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background (
                            if (isSelecteed) ButtonBlue
                            else DarkerButtonBlue
                        )
                        .padding(15.dp)
                )
                {
                        Text(text = chips[it], color  = TextWhite)
                }
        }
    }
}


@Composable
fun GreetingSection(name: String = "Qazeem Abiodun") {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
        ) {
            Column( verticalArrangement = Arrangement.Center ) {
                Text("Good morning, $name", style =  MaterialTheme.typography.h5)
                Text("We wish you have a good day", style =  MaterialTheme.typography.body1)
            }
            Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search" , tint =  Color.White, modifier =  Modifier.size(24.dp
            ))
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}