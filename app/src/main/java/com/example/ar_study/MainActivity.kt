package com.example.ar_study

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ar_study.categories.AllCategoriesScreen
import com.example.ar_study.categories.CategoryScreen
import com.example.ar_study.detail.DetailScreen
import com.example.ar_study.models.Category
import com.example.ar_study.models.Topic
import com.example.ar_study.navigator.BottomNavigator
import com.example.ar_study.onboarding.OnBoardingScreen
import com.example.ar_study.ui.theme.AR_StudyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }
            setOnExitAnimationListener{screen->
                val zoomX = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.4f,
                    0.0f

                )
                zoomX.interpolator = OvershootInterpolator()
                zoomX.duration = 500L
                zoomX.doOnEnd { screen.remove() }

                val zoomY = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.4f,
                    0.0f
                )
                zoomY.interpolator = OvershootInterpolator()
                zoomY.duration = 500L
                zoomY.doOnEnd { screen.remove() }
                zoomX.start()
                zoomY.start()
            }
        }
        setContent {
            AR_StudyTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    ) {
                    val navController = rememberNavController()
                    val viewModel = hiltViewModel<MainViewModel>()
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.background5),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    NavHost(navController = navController, startDestination = "onboarding_screen") {
                        composable(route = "onboarding_screen") {
                            OnBoardingScreen(navController)
                        }
                        composable(route = "home_screen") {
                            BottomNavigator(navController)
                        }
                        composable(
                            route = "detail_screen/{topic}",
                            arguments = listOf(
                                navArgument("topic"){
                                    type= NavType.StringType
                                },
                            )
                            ) {
                            viewModel.reloadList()
                            val topicName = remember{
                                it.arguments?.getString("topic")
                            } ?:""
                            val viewModel = hiltViewModel<MainViewModel>()
                            val allTopics = viewModel.Topics.value
                            val topic:Topic = allTopics.filter {
                                it.topicName==topicName
                            }[0]
                            DetailScreen(topic = topic){
                                navController.popBackStack()
                            }
                        }
                        composable(
                            route = "category_screen/{category}",
                            arguments = listOf(
                                navArgument("category") {
                                    type = NavType.StringType
                                },
                                )
                        ) {
                            viewModel.reloadList()
                            val categoryName = remember {
                                it.arguments?.getString("category")
                            }?:""
                            val viewModel = hiltViewModel<MainViewModel>()
                            val categories = viewModel.Categories.value
                            val category:Category = categories.filter {
                                it.categoryName == categoryName
                            }[0]
                            CategoryScreen(category = category, navigateToTopic = {
                                navController.navigate(
                                    "detail_screen/$it"
                                ){
                                    launchSingleTop = true
                                }
                            }, onBackClick = {
                                navController.popBackStack()
                            }
                            )
                        }

                    }
                }
            }
        }
    }
}

