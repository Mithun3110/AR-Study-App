package com.example.ar_study.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
import com.example.ar_study.common.CategoryItem
import com.example.ar_study.common.SearchBar
import com.example.ar_study.ui.theme.AR_StudyTheme

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    bottomNavController: NavHostController,
    navigateToCategory:(String)->Unit
) {
    val viewModel = hiltViewModel<MainViewModel>()
    val allCategories = viewModel.Categories.value
    Box(

        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background5),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Image(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.End)
                    .padding(end = 20.dp),
                painter = painterResource(id = R.drawable.applogo),
                contentDescription = "Logo"
            )

            Spacer(modifier = Modifier.height(40.dp))
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "Welcome to",
                color = colorResource(id = R.color.text_title),
                fontSize = 28.sp
            )
            Text(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .clickable {
                        navHostController.navigate("details_screen")
                    },
                text = "AR Study",
                color = colorResource(id = R.color.app_primary),
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(30.dp))
            SearchBar(
                modifier = Modifier.padding(horizontal = 20.dp),
                onValueChange = {

                },
                onSearch = {

                },
                readOnly = true,
                text = "",
                onClick = {
                    bottomNavController.navigate("search") {
                        popUpTo(bottomNavController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = false
                        launchSingleTop = true
                    }

                }

            )
            Spacer(modifier = Modifier.height(30.dp))
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    text = "Categories",
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    modifier = Modifier.clickable {
//                        navHostController.navigate("allCategories_screen")
//                    },
//                    text = "View all",
//                    fontSize = 16.sp,
//                    color = Color.Blue
//                )
//            }
//            Spacer(modifier = Modifier.height(12.dp))
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(1),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 20.dp, end = 20.dp),
//                horizontalArrangement = Arrangement.spacedBy(16.dp),
//                verticalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                items(allCategories) { item ->
//                    CategoryCard(
//                        item = item,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(200.dp),
//                        onClick = {
//                            navHostController.navigate("category_screen/${item.categoryName}")
//                        }
//                    )
//
//                }
//
//            }
            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = "Recommended",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            AutomaticSwipeSection(catgories = allCategories, onClick = {
                navigateToCategory(it)
            })


        }
    }


}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    AR_StudyTheme {
        HomeScreen(
            navHostController = rememberNavController(),
            bottomNavController = rememberNavController()
        ){

        }
    }

}

val CategoryItems = listOf<CategoryItem>(
    CategoryItem(
        categoryName = "Biology",
        image = R.drawable.onboarding3,
        courses = 2
    ),
    CategoryItem(
        categoryName = "Machines",
        image = R.drawable.onboarding1,
        courses = 2
    ),
    CategoryItem(
        categoryName = "Space",
        image = R.drawable.onboarding2,
        courses = 2
    ),
    CategoryItem(
        categoryName = "Biology",
        image = R.drawable.onboarding3,
        courses = 2
    ),
    CategoryItem(
        categoryName = "Machines",
        image = R.drawable.onboarding1,
        courses = 2
    ),
    CategoryItem(
        categoryName = "Space",
        image = R.drawable.onboarding2,
        courses = 2
    )

)