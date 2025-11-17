package kuzina.com.ui.components.buttons


import android.provider.CalendarContract
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kuzina.com.R
import kuzina.com.ui.theme.Inter

@Composable
fun CustomAuthButton(onClick: () -> Unit, text: Int) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.primaryColor),
            contentColor = colorResource(id = R.color.white)
        ),
        contentPadding = PaddingValues(
            horizontal = 35.dp,
            vertical = 18.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(56.dp)
    ) {
        Text(
            text = stringResource(id = text),
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,

        )
    }
}


@Composable
fun GoogleButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        contentPadding = PaddingValues(
            horizontal = 35.dp,
            vertical = 18.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(56.dp)
            .border(
                width = 2.dp,
                color = colorResource(id = R.color.text_color),
                RoundedCornerShape(50.dp)
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.size(15.dp))

        Text(
            text = stringResource(id = R.string.Google),
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.text_color)
        )
    }
}

@Preview
@Composable
fun GoogleButtonPreview(){
    GoogleButton({})
}