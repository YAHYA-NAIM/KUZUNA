package kuzina.com.ui.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kuzina.com.ui.components.textfields.passwordfield
import kuzina.com.ui.theme.Inter
import kuzina.com.R
import kuzina.com.ui.components.textfields.authTextField

@Composable
fun LoginScreen(){
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Spacer(modifier = Modifier.size(30.dp))

        Text(
            text = stringResource(id = R.string.welcome_back),
            modifier = Modifier.fillMaxWidth(),
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
        )

        Spacer(modifier = Modifier.size(15.dp))

        Text(
            text = stringResource(id = R.string.login_desc),
            modifier = Modifier.fillMaxWidth(),
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.login_desc),
        )
        Spacer(modifier = Modifier.size(15.dp))




        authTextField(
            iconLeadingRes = R.drawable.ic_email,
            hintTextRes = R.string.email_hint,
            text = email,
            onTextChange = { email = it }
        )
        Spacer(modifier = Modifier.size(5.dp))
        passwordfield(
            iconLeadingRes = R.drawable.ic_lock,
            hintTextRes = R.string.password_hint,
            password = password,
            onPasswordChange = { password = it },
            isPasswordVisble = isPasswordVisible,
            onPasswordToggle = { isPasswordVisible = !isPasswordVisible },
        )
    }

}

@Preview(showBackground = true)
@Composable
fun LoginPreview(){
    LoginScreen()
}
