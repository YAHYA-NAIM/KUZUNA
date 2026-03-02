package kuzina.com.ui.screens.home

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kuzina.com.R
import kuzina.com.util.constants.Routes

class WaveyBottomBarShape(
    private val waveHeight: Dp,
    private val waveCenterX: Float
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val h = size.height
        val w = size.width
        val waveY = with(density) { waveHeight.toPx() }

        val barColorHeight = h - waveY
        val waveWidth = w * 0.4f
        val start = waveCenterX - waveWidth / 2f
        val end = waveCenterX + waveWidth / 2f

        val dipY = h - waveY * 0.2f

        val path = Path().apply {
            moveTo(0f, h)
            lineTo(0f, barColorHeight)
            lineTo(start, barColorHeight)

            cubicTo(
                start + waveWidth * 0.3f, barColorHeight,
                waveCenterX - waveWidth * 0.3f, dipY,
                waveCenterX, dipY
            )
            cubicTo(
                waveCenterX + waveWidth * 0.3f, dipY,
                end - waveWidth * 0.3f, barColorHeight,
                end, barColorHeight
            )

            lineTo(w, barColorHeight)
            lineTo(w, h)
            close()
        }

        return Outline.Generic(path)
    }
}

// --- Nav item data class ---
data class NavItem(val route: String, val drawableRes: Int)

@Composable
fun CurvedBottomBar(
    selectedRoute: String,
    onNavigate: (String) -> Unit
) {
    val items = remember {
        listOf(
            NavItem(Routes.HomeTab.route, R.drawable.ic_home),
            NavItem(Routes.FavorisTab.route, R.drawable.ic_favoris),
            NavItem(Routes.ProfileTab.route, R.drawable.ic_profile)
        )
    }

    val primaryColor = colorResource(R.color.primaryColor)
    val barBackgroundColor =  colorResource(R.color.unselected)

    val barHeight = 80.dp
    val waveHeight = barHeight

    val configuration = LocalConfiguration.current
    val screenWidthPx = with(LocalDensity.current) { configuration.screenWidthDp.dp.toPx() }
    val screenWidthDp = configuration.screenWidthDp.dp

    val waveCenterX = remember { Animatable(0f) }
    val selectedIndex = items.indexOfFirst { it.route == selectedRoute }.coerceAtLeast(0)

    LaunchedEffect(selectedRoute) {
        val itemWidth = screenWidthPx / items.size
        waveCenterX.animateTo(
            targetValue = selectedIndex * itemWidth + itemWidth / 2f,
            animationSpec = spring(dampingRatio = 0.7f, stiffness = 150f)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(barHeight)
    ) {
        // Background bar with wave shape
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(barHeight)
                .clip(WaveyBottomBarShape(waveHeight, waveCenterX.value))
                .background(barBackgroundColor) // this is the rectangle part; can be partially transparent
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(barHeight),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable { onNavigate(item.route) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    if (item.route != selectedRoute) {
                        Image(
                            painter = painterResource(id = item.drawableRes),
                            contentDescription = item.route,
                            modifier = Modifier.size(30.dp),
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(primaryColor)
                        )
                    }
                }
            }
        }

        // Selected icon stays the same
        val itemWidthDp = screenWidthDp / items.size
        val selectedIconOffset = itemWidthDp * selectedIndex + itemWidthDp / 2

        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(x = selectedIconOffset - 25.dp, y = (-20.dp))
                .size(50.dp)
                .clip(CircleShape)
                .background(primaryColor)
                .clickable { onNavigate(items[selectedIndex].route) },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = items[selectedIndex].drawableRes),
                contentDescription = items[selectedIndex].route,
                modifier = Modifier.size(30.dp),
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurvedBottomBarPreview() {
    var selectedItem by remember { mutableStateOf("home") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ){
        }

        CurvedBottomBar(
            selectedRoute = selectedItem,
            onNavigate = { selectedItem = it }
        )
    }
}