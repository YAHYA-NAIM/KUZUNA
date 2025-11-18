package kuzina.com.ui.screens.onboardings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import kuzina.com.R
import kuzina.com.ui.theme.W
import kuzina.com.ui.theme.H

@Composable
fun IndicatorUI(
    pageSize: Int,
    currentPage: Int,
    selectedColor: Color = colorResource(id = R.color.primaryColor),
    unselectedColor: Color = colorResource(id = R.color.unselected),
    dotSizeFraction: Float = 0.03f, // fraction of screen width
    spacingFraction: Float = 0.015f // fraction of screen width
) {
    Row(horizontalArrangement = Arrangement.Center) {
        repeat(pageSize) {
            Spacer(modifier = Modifier.width(W(spacingFraction)))

            Box(
                modifier = Modifier
                    .size(W(dotSizeFraction), W(dotSizeFraction)) // responsive size
                    .clip(RoundedCornerShape(W(dotSizeFraction / 2)))
                    .background(color = if (it == currentPage) selectedColor else unselectedColor)
            )

            Spacer(modifier = Modifier.width(W(spacingFraction)))
        }
    }
}

@Composable
fun IndicatorUIPreview() {
    Row(horizontalArrangement = Arrangement.spacedBy(W(0.02f))) {
        IndicatorUI(pageSize = 3, currentPage = 0)
    }
}
