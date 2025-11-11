package kuzina.com.ui.screens.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kuzina.com.R
import kuzina.com.data.preferences.OnboardingPrefs
import kuzina.com.viewmodel.SplashViewModelFactory

@Composable
fun SplashScreen(
    onNavigate: (String) -> Unit
) {
    val context = LocalContext.current
    val prefs = OnboardingPrefs(context)
    val viewModel : SplashViewModel = viewModel(
        factory = SplashViewModelFactory(prefs)
    )

    val nextRoute by viewModel.nextRoute.collectAsState()
    nextRoute?.let { route ->
        onNavigate(route.route)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primaryColor)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Splash Logo",
            modifier = Modifier.size(150.dp)
        )
    }
}
