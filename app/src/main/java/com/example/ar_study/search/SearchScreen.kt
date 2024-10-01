package com.example.ar_study.search

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ar_study.MainViewModel
import com.example.ar_study.R
import com.example.ar_study.common.CategoryCard
import com.example.ar_study.common.SearchBar
import com.example.ar_study.common.TopicCard2
import com.example.ar_study.home.CategoryItems

@Composable
fun SearchScreen(
    navHostController: NavHostController,
    navigateToCategory:(String)->Unit,
    navigateToTopic:(String)->Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val viewModel = hiltViewModel<MainViewModel>()
        val allCategories = viewModel.Categories.value
        val allTopics = viewModel.Topics.value
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background5),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp),
                text = "Search",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            SearchBar(
                modifier = Modifier.padding(20.dp),
                text = "",
                readOnly = false,
                onValueChange = {

                },
                onSearch = {


                }
            )
            Spacer(modifier = Modifier.height(20.dp))


            if(allCategories.isNotEmpty()){
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "Categories",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(12.dp))
                LazyRow(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(allCategories) { item ->
                        CategoryCard(
                            item = item, modifier = Modifier
                                .height(200.dp)
                                .width(300.dp),
                            onClick ={
                                navigateToCategory(item.categoryName)
                            }
                        )

                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            if(allTopics.isNotEmpty()){
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "Topics",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(12.dp))
                LazyRow(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(allTopics) { item ->
                        TopicCard2(
                            item = item, modifier = Modifier
                                .height(200.dp)
                                .width(300.dp),
                            navigateToTopic = {
                                navigateToTopic((it))
                            }
                        )

                    }

                }
            }


        }
    }

}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    SearchScreen(navHostController = rememberNavController(), navigateToCategory = {}, navigateToTopic = {}
    )

}