package kuzina.com.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kuzina.com.data.preferences.OnboardingPrefs
import kuzina.com.ui.screens.splashscreen.SplashViewModel

class SplashViewModelFactory(
    private val prefs: OnboardingPrefs
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel(prefs) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
