package com.example.ar_study.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ar_study.R
import com.example.ar_study.common.TopicCard
import com.example.ar_study.common.TopicCard2
import com.example.ar_study.models.Category

@Composable
fun CategoryScreen(
    category: Category,
    onBackClick:()->Unit,
    navigateToTopic:(topicName:String)->Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background5),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(40.dp).clickable {
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
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp)
                    .height(300.dp)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = category.coverImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                startY = 0.4f,
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        )
                )
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp, bottom = 20.dp)
                        .align(Alignment.BottomStart),
                    text = category.categoryName,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Topics", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(category.topics){ topic->
                    TopicCard2(item = topic, modifier = Modifier.height(150.dp).fillMaxWidth(), navigateToTopic = {
                        navigateToTopic(it)
                    })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryScreenPreview() {
    CategoryScreen(
        category = com.example.ar_study.models.CategoryItems[0], onBackClick = {}, navigateToTopic = {}
    )

}

