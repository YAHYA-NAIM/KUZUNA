package kuzina.com.ui.screens.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kuzina.com.data.preferences.OnboardingPrefs
import kuzina.com.util.constants.Routes


class SplashViewModel (
    private  val onboardingprefs : OnboardingPrefs
): ViewModel() {

    private val _nextRoute = MutableStateFlow<Routes?>(null)
    val nextRoute = _nextRoute.asStateFlow()
    private val splashDuration = 3000L

    init {
        deciceNextScreen()
    }

    private fun deciceNextScreen() {
        viewModelScope.launch {
            delay(splashDuration)
            if(onboardingprefs.isOnboardingCompleted()){
                _nextRoute.value = Routes.Home
            }else{
                _nextRoute.value = Routes.Onboarding
            }

        }
    }
}
