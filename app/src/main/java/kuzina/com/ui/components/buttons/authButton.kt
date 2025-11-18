package kuzina.com.ui.components.buttons

import androidx.compose.foundation.border
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
import kuzina.com.R
import kuzina.com.ui.theme.Inter
import kuzina.com.ui.theme.W
import kuzina.com.ui.theme.H
import androidx.compose.ui.unit.sp

@Composable
fun CustomAuthButton(onClick: () -> Unit, text: Int) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(W(0.12f)),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.primaryColor),
            contentColor = colorResource(id = R.color.white)
        ),
        contentPadding = PaddingValues(
            horizontal = W(0.09f),
            vertical = H(0.02f)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = W(0.04f), vertical = H(0.008f))  // responsive padding
            .height(H(0.07f))
    ) {
        Text(
            text = stringResource(id = text),
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            fontSize = H(0.022f).value.sp
        )
    }
}

@Composable
fun GoogleButton(onClick: () -> Unit, text: Int) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        contentPadding = PaddingValues(
            horizontal = W(0.09f),
            vertical = H(0.02f)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = W(0.04f), vertical = H(0.010f))
            .height(H(0.070f))
            .border(
                width = H(0.003f),  // ≈ 2dp
                color = colorResource(id = R.color.text_color),
                shape = RoundedCornerShape(W(0.12f))
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.size(W(0.035f)))  // ≈ 15dp

        Text(
            text = stringResource(id = text),
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            fontSize = H(0.022f).value.sp,
            color = colorResource(id = R.color.text_color)
        )
    }
}

@Composable
fun PreviewButtons() {
    Column {
        CustomAuthButton({}, R.string.Sign_up)
        GoogleButton({}, R.string.Google)
    }
}
