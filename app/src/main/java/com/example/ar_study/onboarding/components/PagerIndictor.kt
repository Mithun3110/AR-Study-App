package com.example.ar_study.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.ar_study.Dimens.IndicatorSize
import com.example.ar_study.R
import com.example.ar_study.ui.theme.BlueGray

@Composable
fun PagerIndicator(
    modifier :Modifier = Modifier,
    pageSize : Int,
    selectedPage : Int,
    selectedColor: Color = colorResource(id = R.color.app_primary),
    unselectedColor : Color = BlueGray
) {

    Row (modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween){
        repeat(times = pageSize){page ->
            Box(modifier = Modifier
                .height(IndicatorSize)
                .width(IndicatorSize)
                .clip(CircleShape)
                .background(if (page == selectedPage) selectedColor else unselectedColor)
            )
        }

    }

}