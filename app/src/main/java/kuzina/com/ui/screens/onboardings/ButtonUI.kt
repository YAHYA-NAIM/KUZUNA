package kuzina.com.ui.screens.onboardings

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kuzina.com.R


@Composable
fun ButtonUi(
    text : Int,
    BackgroundColor : Color = colorResource(id = R.color.primaryColor),
    textColor: Color = colorResource(id = R.color.white),
    textStyle : TextStyle = MaterialTheme.typography.titleMedium,
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
            style = textStyle
        )
    }

}

@Preview(showBackground = true)
@Composable
fun NextButton(){
ButtonUi(text = R.string.next) {

}
}
@Preview(showBackground = true)
@Composable
fun BackButton(){
    ButtonUi(
        text =  R.string.back,
        BackgroundColor = Color.Transparent,
        textColor = colorResource(id = R.color.primaryColor),
        textStyle = MaterialTheme.typography.bodySmall,
        fontsize = 13
    ) {

    }
}