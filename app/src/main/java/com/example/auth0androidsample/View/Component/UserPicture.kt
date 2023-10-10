package com.example.auth0androidsample.View.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun UserPicture(  // 1
    url: String,
    description: String,
) {
    Column(  // 2
        modifier = Modifier
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(  // 3
            painter = rememberAsyncImagePainter(url),
            contentDescription = description,
            modifier = Modifier
                .fillMaxSize(0.5f),
        )
    }
}
