package kuzina.com.ui.screens.onboardings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kuzina.com.R
import androidx.compose.animation.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kuzina.com.data.model.OnboardingModel
import kuzina.com.data.preferences.OnboardingPrefs
import kuzina.com.ui.screens.onboardings.components.CircularIconButton
import kuzina.com.ui.screens.onboardings.components.IndicatorUI
import kuzina.com.ui.screens.onboardings.components.OnboardingGraphUI
import kuzina.com.ui.screens.onboardings.components.StartButton
import kuzina.com.ui.theme.H
import kuzina.com.ui.theme.W

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
                    .padding(horizontal = W(0.04f), vertical = H(0.02f)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Indicator in the center
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
                    IndicatorUI(pages.size, pageState.currentPage)
                }

                // Button on the right
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = W(0.02f)),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    AnimatedContent(
                        targetState = pageState.currentPage == pages.size - 1,
                        label = "OnboardingButtonTransition",
                        transitionSpec = {
                            fadeIn() + scaleIn(initialScale = 0.8f) togetherWith
                                    fadeOut() + scaleOut(targetScale = 0.8f)
                        }
                    ) { isLastPage ->
                        if (isLastPage) {
                            StartButton(
                                textRes = R.string.start,
                                iconRes = R.drawable.ic_start_cooking
                            ) {
                                scope.launch {
                                    prefs.setOnboardingCompleted()
                                    onFinished()
                                }
                            }
                        } else {
                            CircularIconButton(
                                iconRes = R.drawable.ic_arrow_forward,

                            ) {
                                scope.launch {
                                    pageState.animateScrollToPage(pageState.currentPage + 1)
                                }
                            }
                        }
                    }
                }
            }
        },
        content = { paddingValues ->
            Column(Modifier.padding(paddingValues)) {
                HorizontalPager(state = pageState) { index ->
                    OnboardingGraphUI(
                        onboardingModel = pages[index],
                        onSkip = {
                            scope.launch {
                                pageState.scrollToPage(pages.size - 1)
                            }
                        }
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen { }
}
