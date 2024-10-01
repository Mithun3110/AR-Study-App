package com.example.ar_study.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ar_study.R
import com.example.ar_study.models.Category
import com.example.ar_study.models.CategoryItems
import com.example.ar_study.models.Topic

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    item: Category,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                onClick()
            }
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = item.coverImage),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 12.dp, bottom = 16.dp)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = item.categoryName,
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(2.dp))

            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                text = "${item.topics.size} courses",
                fontSize = 14.sp,
                color = Color.LightGray
            )
        }
    }
}


@Composable
fun TopicCard2(
    modifier: Modifier = Modifier,
    item: Topic,
    navigateToTopic: (topicName:String) -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                navigateToTopic(item.topicName)
            }
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = item.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 12.dp, bottom = 16.dp)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = item.topicName,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "${item.stars}",
                    fontSize = 12.sp,
                    color = Color.LightGray
                )

            }
        }
    }
}

@Composable
fun TopicCard(
    modifier: Modifier = Modifier,
    item: Topic
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            modifier = Modifier.size(70.dp),
            painter = painterResource(id = item.image),
            contentDescription = null,
            contentScale = ContentScale.Crop

        )
        Spacer(modifier = Modifier.width(6.dp))
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = item.topicName, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "${item.stars}",
                    fontSize = 12.sp,
                    color = Color.Black.copy(alpha = 0.8f)
                )

            }
        }


    }

}

data class CategoryItem(
    val categoryName: String,
    @DrawableRes val image: Int,
    val courses: Int
)

@Preview(showBackground = true)
@Composable
private fun CategoryCardPreview() {
    CategoryCard(
        item = CategoryItems[0],
        onClick = {}
    )
}

@Preview(showBackground = true, widthDp = 340)
@Composable
private fun TopicCardPreview() {
    TopicCard(
        item = Topic(
            topicName = "Jet Turbine",
            desc = "A jet turbine engine, commonly known as a gas turbine engine, is a type of internal combustion engine that converts fuel into mechanical energy by igniting fuel-air mixtures in a combustion chamber. The resulting high-pressure, high-temperature gases are directed through a series of turbines, which are connected to a shaft. As the gases pass through the turbines, they spin the shaft, which drives various components such as compressors, fans, or generators, depending on the application. In the context of aviation, jet turbine engines are commonly used in jet aircraft to provide thrust for propulsion. These engines are highly efficient and capable of generating significant amounts of power, allowing aircraft to travel at high speeds and altitudes.\n" +
                    "\nIn summary, a jet turbine engine is a type of gas turbine engine used in various applications, including aircraft propulsion and power generation, to convert fuel into mechanical energy",
            image = R.drawable.jetturbine,
            category = "Machinery",
            packageName = "",
            stars = 3.0,
        ),
    )
}