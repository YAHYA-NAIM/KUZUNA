package kuzina.com.ui.screens.onboardings.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kuzina.com.R
import kuzina.com.data.model.OnboardingModel
import kuzina.com.ui.theme.H
import kuzina.com.ui.theme.Inter
import kuzina.com.ui.theme.W

@Composable
fun OnboardingGraphUI(
    onboardingModel: OnboardingModel,
    onSkip: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = W(0.04f), vertical = H(0.02f)),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = stringResource(id = R.string.skip),
                color = colorResource(id = R.color.primaryColor),
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                fontSize = H(0.018f).value.sp, // responsive font size
                modifier = Modifier
                    .padding(horizontal = W(0.02f))
                    .clickable { onSkip() }
            )
        }

        Spacer(modifier = Modifier.height(H(0.04f)))

        Image(
            painter = painterResource(id = onboardingModel.Image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(H(0.4f))
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(H(0.04f)))

        Text(
            text = stringResource(id = onboardingModel.title),
            modifier = Modifier.fillMaxWidth(),
            fontSize = (27 * (W(1f).value / 360)).sp, // responsive font size
            textAlign = TextAlign.Center,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            lineHeight = (30 * (H(1f).value / 640)).sp // responsive line height
        )

        Spacer(modifier = Modifier.height(H(0.02f)))

        Text(
            text = stringResource(id = onboardingModel.description),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = W(0.04f)),
            fontSize = (15 * (W(1f).value / 360)).sp,
            textAlign = TextAlign.Center,
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.description),
            lineHeight = (20 * (H(1f).value / 640)).sp
        )

        Spacer(modifier = Modifier.height(H(0.06f)))
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview1() {
    OnboardingGraphUI(OnboardingModel.FirstPages)
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview2() {
    OnboardingGraphUI(OnboardingModel.SecondPages)
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview3() {
    OnboardingGraphUI(OnboardingModel.ThirdPages)
}
