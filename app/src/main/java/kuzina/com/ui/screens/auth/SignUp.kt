package kuzina.com.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kuzina.com.R
import kuzina.com.ui.components.buttons.CustomAuthButton
import kuzina.com.ui.components.buttons.GoogleButton
import kuzina.com.ui.components.textfields.authTextField
import kuzina.com.ui.components.textfields.passwordfield
import kuzina.com.ui.theme.H
import kuzina.com.ui.theme.W
import kuzina.com.ui.theme.Inter

@Composable
fun SignUpScreen(
    onNext: () -> Unit,
    onSkiptoHome: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    // Height of bottom container = 87% of screen
    val fixedHeight = H(0.87f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.primaryColor))
    ) {
        FoodBackground()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(fixedHeight)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = W(0.06f), vertical = H(0.015f)),
                verticalArrangement = Arrangement.spacedBy(H(0.010f)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(H(0.02f)))

                Text(
                    text = stringResource(id = R.string.welcome),
                    fontSize = (H(0.028f)).value.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black),
                )

                Text(
                    text = stringResource(id = R.string.SignUp_desc),
                    fontSize = (H(0.02f)).value.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.login_desc),
                )

                Spacer(modifier = Modifier.height(H(0.005f)))

                // Text fields
                authTextField(
                    iconLeadingRes = R.drawable.ic_profile,
                    hintTextRes = R.string.name_hint,
                    text = name,
                    onTextChange = { name = it }
                )

                authTextField(
                    iconLeadingRes = R.drawable.ic_email,
                    hintTextRes = R.string.email_hint,
                    text = email,
                    onTextChange = { email = it }
                )

                passwordfield(
                    iconLeadingRes = R.drawable.ic_lock,
                    hintTextRes = R.string.password_hint,
                    password = password,
                    onPasswordChange = { password = it },
                    isPasswordVisble = isPasswordVisible,
                    onPasswordToggle = { isPasswordVisible = !isPasswordVisible },
                )

                passwordfield(
                    iconLeadingRes = R.drawable.ic_lock,
                    hintTextRes = R.string.confirm_password_hint,
                    password = confirmpassword,
                    onPasswordChange = { confirmpassword = it },
                    isPasswordVisble = isPasswordVisible,
                    onPasswordToggle = { isPasswordVisible = !isPasswordVisible },
                )

                Spacer(modifier = Modifier.height(H(0.005f)))

                // Password hints
                Column(
                    modifier = Modifier.fillMaxWidth().padding(start = W(0.02f)),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(id = R.string.password_must),
                        fontSize = (H(0.020f)).value.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.text_color2),
                    )

                    Row(Modifier.fillMaxWidth().padding(horizontal = H(0.005f), vertical = H(0.005f))) {
                        Icon(
                            painter = painterResource(R.drawable.ic_done),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(H(0.025f))
                        )
                        Spacer(modifier = Modifier.width(W(0.02f)))
                        Text(
                            text = stringResource(id = R.string.atleast),
                            fontSize = (H(0.018f)).value.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = R.color.text_color),
                        )
                    }

                    Row(Modifier.fillMaxWidth().padding(horizontal = H(0.005f))) {
                        Icon(
                            painter = painterResource(R.drawable.ic_undone),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(H(0.025f))
                        )
                        Spacer(modifier = Modifier.width(W(0.02f)))
                        Text(
                            text = stringResource(id = R.string.Contains_num),
                            fontSize = (H(0.018f)).value.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = R.color.text_color),
                        )
                    }
                }


                CustomAuthButton({onSkiptoHome()}, text = R.string.Sign_up)

                Text(
                    text = stringResource(id = R.string.or_signup),
                    fontSize = (H(0.018f)).value.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.login_desc),
                    modifier = Modifier.fillMaxWidth()
                )

                GoogleButton({}, text = R.string.Google2)

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.already_mem),
                        fontSize = (H(0.018f)).value.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.text_color),
                    )
                    Spacer(modifier = Modifier.width(W(0.015f)))
                    Text(
                        text = stringResource(id = R.string.login),
                        color = colorResource(id = R.color.primaryColor),
                        fontFamily = Inter,
                        fontWeight = FontWeight.Bold,
                        fontSize = (H(0.018f)).value.sp,
                        modifier = Modifier
                            .clickable { onNext() }
                            .padding(start = W(0.01f))
                    )
                }
            }
        }
    }
}
