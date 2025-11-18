package kuzina.com.ui.screens.onboardings.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kuzina.com.R
import kuzina.com.ui.theme.Inter
import kuzina.com.ui.theme.W
import kuzina.com.ui.theme.H



@Composable
fun CircularIconButton(
    iconRes: Int,
    sizeFraction: Float = 0.12f, // fraction of width
    backgroundColor: Color = colorResource(id = R.color.primaryColor),
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        contentPadding = PaddingValues(H(0.015f)), // responsive padding
        modifier = Modifier.size(W(sizeFraction))
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null
        )
    }
}

@Composable
fun StartButton(
    textRes: Int,
    iconRes: Int,
    onClick: () -> Unit
) {
    val iconSize = H(0.04f).coerceAtMost(W(0.12f))
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(W(0.025f)),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.primaryColor)),
        contentPadding = PaddingValues(horizontal = W(0.05f), vertical = H(0.01f))
    ) {
        Text(
            text = stringResource(id = textRes),
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            fontSize = H(0.018f).value.sp,
            color = colorResource(id = R.color.white)
        )
        Spacer(modifier = Modifier.width(W(0.01f)))
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(iconSize)
        )
    }
}
