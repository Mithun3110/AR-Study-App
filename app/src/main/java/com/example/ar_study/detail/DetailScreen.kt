package com.example.ar_study.detail

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.ar_study.R
import com.example.ar_study.common.NewsButton
import com.example.ar_study.common.RatingBar
import com.example.ar_study.models.Topic
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext

@Composable
fun DetailScreen(
    topic: Topic,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val targetActivityName =
            "com.unity3d.player.UnityPlayerActivity" // Replace with the activity name of the target app

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background5),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            onBackClick()
                        },
                    imageVector = Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = "back",
                )
                Image(
                    modifier = Modifier.size(60.dp),
                    painter = painterResource(id = R.drawable.applogo),
                    contentDescription = "Profile"
                )
            }
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = topic.topicName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    painter = painterResource(id = topic.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Category: ${topic.category}",
                    fontSize = 16.sp,
                    color = Color.Black.copy(alpha = 0.5f),
                    fontWeight = FontWeight.SemiBold,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Rating",
                        fontSize = 14.sp,
                        color = Color.Black.copy(alpha = 0.5f),
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = "(${topic.stars})",
                        fontSize = 10.sp,
                        color = Color.Black.copy(alpha = 0.5f),
                        fontWeight = FontWeight.SemiBold,
                    )
                    Spacer(modifier = Modifier.width(3.dp))

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.LightGray)
                            .padding(2.dp)
                    )
                    {
                        RatingBar(
                            rating = topic.stars,
                            starsModifier = Modifier.size(15.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = topic.desc,
                    fontSize = 16.sp,
                    color = Color.Black.copy(alpha = 0.7f),
                    fontWeight = FontWeight.Normal,
                )
            }


        }
        NewsButton(
            text = "View in AR",
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 20.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            onClick = {
                val intent = Intent().apply {
                    component = ComponentName(topic.packageName, targetActivityName)
                }
                try {
                    context.startActivity(intent)

                }catch(e:ActivityNotFoundException){
                    e.printStackTrace()
                }



                // Start the activity
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun DetailsScreenPrev() {
    DetailScreen(
        topic = Topic(
            topicName = "Jet Turbine",
            desc = "A jet turbine engine, commonly known as a gas turbine engine, is a type of internal combustion engine that converts fuel into mechanical energy by igniting fuel-air mixtures in a combustion chamber. The resulting high-pressure, high-temperature gases are directed through a series of turbines, which are connected to a shaft. As the gases pass through the turbines, they spin the shaft, which drives various components such as compressors, fans, or generators, depending on the application. In the context of aviation, jet turbine engines are commonly used in jet aircraft to provide thrust for propulsion. These engines are highly efficient and capable of generating significant amounts of power, allowing aircraft to travel at high speeds and altitudes.\n" +
                    "\nIn summary, a jet turbine engine is a type of gas turbine engine used in various applications, including aircraft propulsion and power generation, to convert fuel into mechanical energy",
            image = R.drawable.jetturbine,
            category = "Machinery",
            packageName = "com.Meehtan.JetTurbine",
            stars = 3.5,
        ),
        onBackClick = {}
    )

}