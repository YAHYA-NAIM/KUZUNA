package kuzina.com.ui.screens.onboardings.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kuzina.com.R
import kuzina.com.data.model.OnboardingModel
import kuzina.com.ui.theme.Inter

@Composable
fun OnboardingGraphUI (
    onboardingModel: OnboardingModel,
    onSkip: () -> Unit = {}
) {
    Column (modifier = Modifier.fillMaxWidth()){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            ButtonUi(
                text = R.string.skip,
                BackgroundColor = Color.Transparent,
                textColor = colorResource(id = R.color.primaryColor),
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                fontsize = 16,
                onClick = onSkip
            )
        }

        Spacer(
            modifier = Modifier.size(30.dp)
        )

        Image(
            painter = painterResource(id = onboardingModel.Image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )

        Spacer(
            modifier = Modifier.size(60.dp)
        )

        Text(
            text = stringResource(id = onboardingModel.title),
            modifier = Modifier.fillMaxWidth(),
            fontSize = 27.sp,
            textAlign = TextAlign.Center,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            lineHeight = 30.sp
        )

        Spacer(
            modifier = Modifier.size(30.dp)
        )

        Text(
            text = stringResource(id = onboardingModel.description),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp,0.dp),
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.description),
            lineHeight = 24.sp
        )
        Spacer(
            modifier = Modifier.size(30.dp)
        )



    }

}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview1(){
    OnboardingGraphUI(OnboardingModel.FirstPages)
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview2(){
    OnboardingGraphUI(OnboardingModel.SecondPages)
}
@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview3(){
    OnboardingGraphUI(OnboardingModel.ThirdPages)
}