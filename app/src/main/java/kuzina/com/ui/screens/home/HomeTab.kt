package kuzina.com.ui.screens.home


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kuzina.com.R
import kuzina.com.ui.components.textfields.searchTextField
import kuzina.com.ui.theme.Inter

@Composable
fun HomeTabScreen() {
    var search by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.hello),
                color = colorResource(R.color.black),
                fontSize = 25.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold
            )
            Box(modifier = Modifier.size(5.dp))
            Text(
                text = stringResource(R.string.HomeHeaderText),
                color = colorResource(R.color.login_desc),
                fontSize = 16.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium
            )
            Box(modifier = Modifier.size(10.dp))
            Row(

            ){
                searchTextField(
                    iconLeadingRes = R.drawable.search_ic,
                    hintTextRes = R.string.search,
                    text = search,
                    onTextChange = { search = it }
                )
                Box(modifier = Modifier.size(5.dp))
                Button(
                    onClick = {  },
                    shape = RoundedCornerShape(17.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.primaryColor),
                        contentColor = colorResource(id = R.color.white)
                    ),
                    modifier = Modifier
                        .size(50.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.filter_ic),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeTabScreen()
}
