package kuzina.com.ui.screens.onboardings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kuzina.com.R
import kuzina.com.data.model.OnboardingModel

@Composable
fun OnboardingScreen(onFinished: () -> Unit) {
    val pages = listOf(
        OnboardingModel.FirstPages,
        OnboardingModel.SecondPages,
        OnboardingModel.ThirdPages
    )
    val pageState = rememberPagerState(initialPage = 0) { pages.size }

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp,5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ButtonUi(
                    text = R.string.back
                ) {

                }

                IndicatorUI(pages.size, pageState.currentPage)

                ButtonUi(
                    text = R.string.next
                ) {

                }
            }
        },
        content = {
            Column(Modifier.padding(it)) {
                HorizontalPager(state = pageState) { index ->
                    OnboardingGraphUI(onboardingModel = pages[index])
                }
            }
        }
    )
}



@Composable
fun OnboardingScreenPreview(){
    OnboardingScreen()
}