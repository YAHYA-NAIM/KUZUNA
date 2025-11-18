package kuzina.com.ui.components.textfields

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import kuzina.com.R
import kuzina.com.ui.theme.W
import kuzina.com.ui.theme.H

@Composable
fun authTextField(
    iconLeadingRes: Int,
    hintTextRes: Int,
    text: String,
    onTextChange: (String) -> Unit,
    cornerRaduis: Dp = W(0.12f)
) {
    var isFocused by remember { mutableStateOf(false) }

    val borderWidthFocused = H(0.003f)
    val borderWidthUnfocused = H(0.0015f)

    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        placeholder = {
            Text(
                text = stringResource(id = hintTextRes),
                color = colorResource(id = R.color.login_desc),
                style = TextStyle(lineHeight = H(0.025f).value.sp)
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconLeadingRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = W(0.05f), end = W(0.02f))
                    .height(H(0.03f))
                    .aspectRatio(1f)  // ≈ 15dp
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(cornerRaduis),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.primaryColor),
            unfocusedBorderColor = colorResource(id = R.color.text_field_border),
            cursorColor = colorResource(id = R.color.primaryColor)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(H(0.075f))   // ≈ 65dp
            .border(
                width = if (isFocused) borderWidthFocused else borderWidthUnfocused,
                color = if (isFocused) colorResource(id = R.color.primaryColor)
                else colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(cornerRaduis)
            )
            .onFocusChanged { isFocused = it.isFocused }
    )
}

@Composable
fun passwordfield(
    iconLeadingRes: Int,
    hintTextRes: Int,
    password: String,
    onPasswordChange: (String) -> Unit,
    isPasswordVisble: Boolean,
    onPasswordToggle: () -> Unit,
    cornerRaduis: Dp = W(0.12f)   // ≈ 50dp
) {
    var isFocused by remember { mutableStateOf(false) }

    val borderWidthFocused = H(0.003f)
    val borderWidthUnfocused = H(0.002f)

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        placeholder = {
            Text(
                text = stringResource(id = hintTextRes),
                color = colorResource(id = R.color.login_desc),
                style = TextStyle(lineHeight = H(0.025f).value.sp)
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconLeadingRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = W(0.05f), end = W(0.02f))
                    .height(H(0.03f))
                    .aspectRatio(1f)
            )
        },
        trailingIcon = {
            IconButton(
                onClick = onPasswordToggle,
                modifier = Modifier.padding(start = W(0.05f), end = W(0.03f))

            ) {
                val iconRes = if (isPasswordVisble)
                    R.drawable.ic_visibility_off
                else
                    R.drawable.ic_visibility

                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    tint = colorResource(id = R.color.login_desc),
                    modifier = Modifier

                        .height(H(0.032f))
                        .aspectRatio(1f)
                )
            }
        },
        visualTransformation = if (isPasswordVisble)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),
        singleLine = true,
        shape = RoundedCornerShape(cornerRaduis),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.primaryColor),
            unfocusedBorderColor = colorResource(id = R.color.text_field_border),
            cursorColor = colorResource(id = R.color.primaryColor)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(H(0.075f))   // responsive height
            .border(
                width = if (isFocused) borderWidthFocused else borderWidthUnfocused,
                color = if (isFocused) colorResource(id = R.color.primaryColor)
                else colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(cornerRaduis)
            )
            .onFocusChanged { isFocused = it.isFocused }
    )
}
