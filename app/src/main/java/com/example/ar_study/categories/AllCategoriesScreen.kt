package com.example.ar_study.categories

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ar_study.MainViewModel
import com.example.ar_study.R
import com.example.ar_study.common.CategoryCard
import com.example.ar_study.common.TopicCard2

@Composable
fun AllCategoriesScreen(
    onBackClick: () -> Unit,
    navigateToTopic: (String) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val viewModel = hiltViewModel<MainViewModel>()
        val allCategories = viewModel.Categories.value
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
            Spacer(modifier = Modifier.height(20.dp))

            Image(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.End)
                    .padding(end = 20.dp),
                painter = painterResource(id = R.drawable.applogo),
                contentDescription = "Profile"
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "All Categories",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            allCategories.forEach { category ->
                Text(
                    text = category.categoryName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(category.topics) { topic ->
                        TopicCard2(item = topic, modifier = Modifier.size(200.dp)) {
                            navigateToTopic(it)
                        }


                    }

                }
                Spacer(modifier = Modifier.height(20.dp))


            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun AllCategoriesPreview() {
    AllCategoriesScreen(onBackClick = {}, navigateToTopic = {})
}