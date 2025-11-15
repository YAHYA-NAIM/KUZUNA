package kuzina.com.ui.components.textfields

import androidx.compose.foundation.border
import androidx.compose.material3.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kuzina.com.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun authTextField(
    iconLeadingRes: Int,
    hintTextRes: Int,
    text: String,
    onTextChange: (String) -> Unit,
    cornerRaduis: Dp = 50.dp
) {
    var isFocused by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        placeholder = {
            Text(
                text = stringResource(id = hintTextRes),
                color = colorResource(id = R.color.login_desc)
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconLeadingRes),
                contentDescription = null,
                modifier = Modifier.padding(start = 15.dp)
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
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(
                width = if (isFocused) 1.dp else 2.5.dp,
                color = if (isFocused) colorResource(id = R.color.primaryColor)
                else colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(cornerRaduis)
            )
            .onFocusChanged { focusState -> isFocused = focusState.isFocused }
    )
}

@Composable
fun passwordfield(
    iconLeadingRes: Int,
    hintTextRes: Int,
    password : String,
    onPasswordChange : (String) -> Unit,
    isPasswordVisble: Boolean,
    onPasswordToggle : () -> Unit,
    cornerRaduis : Dp = 50.dp
){
    var isFocused by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        placeholder = { Text(text = stringResource(id = hintTextRes), color = colorResource(id = R.color.login_desc)) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconLeadingRes),
                contentDescription = null,
                modifier = Modifier.padding(start = 15.dp)
            )
        },
        trailingIcon = {
            IconButton(onClick = onPasswordToggle,modifier = Modifier.padding( end = 15.dp)) {
                val iconRes = if (isPasswordVisble) {
                    R.drawable.ic_visibility_off
                } else {
                    R.drawable.ic_visibility
                }
                Icon(painter = painterResource(id = iconRes),
                    contentDescription = null,
                    tint =colorResource(id = R.color.login_desc), )
            }
        },
        visualTransformation = if (isPasswordVisble) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = true,
        shape = RoundedCornerShape(cornerRaduis),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.primaryColor),
            unfocusedBorderColor = colorResource(id = R.color.text_field_border),
            cursorColor = colorResource(id = R.color.primaryColor)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(
                width = if (isFocused) 1.dp else 2.5.dp ,
                color = if (isFocused) colorResource(id = R.color.primaryColor)
                else colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(cornerRaduis)
            )
            .onFocusChanged { focusState -> isFocused = focusState.isFocused }
    )

}
