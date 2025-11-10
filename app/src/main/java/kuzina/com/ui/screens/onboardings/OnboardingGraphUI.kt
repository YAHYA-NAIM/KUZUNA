package kuzina.com.ui.screens.onboardings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kuzina.com.R
import kuzina.com.data.model.OnboardingModel

@Composable
fun OnboardingGraphUI (onboardingModel: OnboardingModel) {
    Column (modifier = Modifier.fillMaxWidth()){

        Spacer(
            modifier = Modifier.size(70.dp)
        )

        Image( painter = painterResource(id = onboardingModel.Image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp, 0.dp ),
            alignment = Alignment.Center
        )

        Spacer(
            modifier = Modifier.size(30.dp)
        )

        Text(
            text = stringResource(id = onboardingModel.title),
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(
            modifier = Modifier.size(40.dp)
        )

        Text(
            text = stringResource(id = onboardingModel.description),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp,0.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall,
            color = colorResource(id = R.color.description)
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