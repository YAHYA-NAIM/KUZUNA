package kuzina.com.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Dimens {
    var width = 0.dp
    var height = 0.dp
}

@Composable
fun ProvideDimens() {
    val config = LocalConfiguration.current
    Dimens.width = config.screenWidthDp.dp
    Dimens.height = config.screenHeightDp.dp
}

@Composable
fun W(fraction: Float) = Dimens.width * fraction

@Composable
fun H(fraction: Float) = Dimens.height * fraction

