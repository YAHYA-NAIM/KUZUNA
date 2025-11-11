package kuzina.com.ui.screens.onboardings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kuzina.com.R
import kuzina.com.data.model.OnboardingModel
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch
import kuzina.com.data.preferences.OnboardingPrefs
import kuzina.com.ui.screens.onboardings.components.ButtonUi
import kuzina.com.ui.screens.onboardings.components.IndicatorUI
import kuzina.com.ui.screens.onboardings.components.OnboardingGraphUI

@Composable
fun OnboardingScreen(onFinished: () -> Unit) {
    val pages = listOf(
        OnboardingModel.FirstPages,
        OnboardingModel.SecondPages,
        OnboardingModel.ThirdPages
    )
    val pageState = rememberPagerState(initialPage = 0) { pages.size }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val prefs = OnboardingPrefs(context)

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp,5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box (modifier = Modifier.weight(1f),
                    Alignment.CenterStart){
                    if (pageState.currentPage > 0){
                        ButtonUi(
                            text = R.string.back,
                            Color.Transparent,
                            textColor = colorResource(id = R.color.primaryColor)

                        ) {
                            scope.launch {
                                if (pageState.currentPage > 0) {
                                    pageState.animateScrollToPage(pageState.currentPage - 1)
                                }
                            }

                        }
                    }
                }


                Box (modifier = Modifier.weight(1f),
                    Alignment.Center){
                    IndicatorUI(pages.size, pageState.currentPage)
                }


                Box (modifier = Modifier.weight(1f),
                    Alignment.CenterEnd){
                    val rightButtonText = if (pageState.currentPage == pages.size - 1){
                        R.string.start
                    }else{
                        R.string.next
                    }
                    ButtonUi(
                        text = rightButtonText,
                        BackgroundColor = colorResource(id = R.color.primaryColor),
                        textColor = colorResource(id = R.color.white),
                    ) {
                        scope.launch {
                            if (pageState.currentPage < pages.size - 1) {
                                pageState.animateScrollToPage(pageState.currentPage + 1)
                            } else {
                                prefs.setOnboardingCompleted()
                                onFinished()
                            }
                        }
                    }
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


@Preview
@Composable
fun OnboardingScreenPreview(){
    OnboardingScreen{

    }
}