package com.akshai.ezetapmachinetest.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun SimpleImage(url: String) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = "Andy Rubin",
        modifier = Modifier
            .size(200.dp)
    )
}