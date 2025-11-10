package kuzina.com.ui.screens.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kuzina.com.util.constants.Routes


class SplashViewModel : ViewModel() {
    private val _nextRoute = MutableStateFlow<Routes?>(null)
    val nextRoute = _nextRoute.asStateFlow()
    private val splashDuration = 3000L

    init {
        navigateToHome()
    }

    private fun navigateToHome() {
        viewModelScope.launch {
            delay(splashDuration)
            _nextRoute.value = Routes.Home
        }
    }
}
