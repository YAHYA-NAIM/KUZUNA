package kuzina.com.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import kuzina.com.R

@Composable
fun FoodBackground() {
    Image(
        imageVector = ImageVector.vectorResource(id = R.drawable.food_background),
        contentDescription = "Food Illustrations",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}