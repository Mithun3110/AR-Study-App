package com.example.ar_study.onboarding

import androidx.annotation.DrawableRes
import com.example.ar_study.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)
val pages = listOf(
    Page(
        title = "Innovation at your fingertips",
        description = "Dive into a realm where knowledge comes to life through augmented reality.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Education meets innovation",
        description = "Explore, engage, and experience education like never before",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Engage, interact, learn.",
        description = "Get ready to redefine your educational experience with augmented reality.",
        image = R.drawable.onboarding3
    )

)
