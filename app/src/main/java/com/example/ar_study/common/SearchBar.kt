package com.example.ar_study.common

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ar_study.MainViewModel
import com.example.ar_study.R

@Composable
fun SearchBar(
    modifier:Modifier = Modifier,
    text: String,
    readOnly:Boolean,
    onClick:(()->Unit)?=null,
    onValueChange:(String)->Unit,
    onSearch:()->Unit
) {
    val viewModel = hiltViewModel<MainViewModel>()
    var text by remember{
        mutableStateOf("")
    }
    val interactionSource = remember{
        MutableInteractionSource()
    }
    val isClicked = interactionSource.collectIsPressedAsState().value
    LaunchedEffect(key1 = isClicked) {
        if(isClicked){
            onClick?.invoke()
        }
    }
    BasicTextField(
        modifier = modifier
            .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(15.dp))
            .padding(16.dp),
        value =text,
        onValueChange ={
            text = it
            viewModel.searchList(text)
        },
        singleLine = true,
        maxLines = 1,
        readOnly = readOnly,
        interactionSource = interactionSource,
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = colorResource(id = R.color.display_small)
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
//        keyboardActions = KeyboardActions(
//            onSearch = {
//
//            }
//        )

    ) {innerTextField->
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search"
            )
            Spacer(modifier = Modifier.width(12.dp))
            Box(modifier = Modifier.weight(1f)){
                if(text.isEmpty()){
                    Text(
                        text = "Search...",
                        fontSize = 18.sp,
                        color = colorResource(id = R.color.text_title).copy(alpha = 0.5f)
                    )
                }
                innerTextField()
            }
            Spacer(modifier = Modifier.width(8.dp))
            if(text.isNotEmpty()){
                Icon(
                    modifier = Modifier.clickable {
                        text = ""
                    },
                    imageVector = Icons.Rounded.Clear,
                    contentDescription = "Clear"

                )
            }

        }

    }

}

