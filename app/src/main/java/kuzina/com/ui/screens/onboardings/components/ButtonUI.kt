package kuzina.com.ui.screens.onboardings.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kuzina.com.R
import kuzina.com.ui.theme.Inter


@Composable
fun ButtonUi(
    text : Int,
    BackgroundColor : Color = colorResource(id = R.color.primaryColor),
    textColor: Color = colorResource(id = R.color.white),
    fontFamily : FontFamily,
    fontWeight : FontWeight,
    fontsize : Int = 14,
    onClick : () -> Unit
){
    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = BackgroundColor, contentColor = textColor
        ), shape = RoundedCornerShape(10.dp)
    ){
        Text(
            text = stringResource(id = text),
            fontSize = fontsize.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
        )
    }

}
@Composable
fun CircularIconButton(
    iconRes: Int,
    size: Int = 50,
    backgroundColor: Color = colorResource(id = R.color.primaryColor),
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier.size(size.dp)
    ) {
        androidx.compose.foundation.Image(
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
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.primaryColor)),
        contentPadding = PaddingValues(horizontal = 25.dp, vertical = 10.dp)
    ) {
        Text(
            text = stringResource(id = textRes),
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )


    }
}