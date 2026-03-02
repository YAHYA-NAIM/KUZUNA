package kuzina.com.ui.components.textfields

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kuzina.com.R
import kuzina.com.ui.theme.H
import kuzina.com.ui.theme.W

@Composable
fun searchTextField(
    iconLeadingRes: Int,
    hintTextRes: Int,
    text: String,
    onTextChange: (String) -> Unit,
    cornerRaduis: Dp = 17.dp
){
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
                tint = colorResource(id = R.color.login_desc),
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
            .width(W(0.75f))
            .height(H(0.06f))
            .border(
                width = if (isFocused) borderWidthFocused else borderWidthUnfocused,
                color = if (isFocused) colorResource(id = R.color.primaryColor)
                else colorResource(id = R.color.text_field_border),
                shape = RoundedCornerShape(cornerRaduis)
            )
            .onFocusChanged { isFocused = it.isFocused }
    )
}
