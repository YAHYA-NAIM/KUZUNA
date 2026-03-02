package kuzina.com.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kuzina.com.ui.screens.auth.LoginScreen
import kuzina.com.ui.screens.auth.SignUpScreen
import kuzina.com.ui.screens.home.HomeContainerScreen
import kuzina.com.ui.screens.onboardings.OnboardingScreen
import kuzina.com.ui.screens.splashscreen.SplashScreen
import kuzina.com.util.constants.Routes


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route
    ) {

        composable(Routes.Splash.route) {
            SplashScreen(onNavigate = { route ->
                navController.navigate(route) {
                    popUpTo(Routes.Splash.route) { inclusive = true }
                }
            })
        }

        composable (Routes.Onboarding.route){
            OnboardingScreen(onFinished = {
                navController.navigate(Routes.SignUp.route){
                    popUpTo(Routes.Onboarding.route){ inclusive = true }
                }
            })
        }

        composable (Routes.SignUp.route){
            SignUpScreen(
                onNext = {
                    navController.navigate(Routes.Login.route)
                },
                onSkiptoHome ={
                    navController.navigate(Routes.Home.route){
                        popUpTo (Routes.SignUp.route){ inclusive = true }
                    }
                }
            )
        }

        composable(Routes.Login.route) {
            LoginScreen(
                onNext = {
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                },
                onBackToSignUp = {
                    navController.navigate(Routes.SignUp.route)
                }
            )
        }

        composable(Routes.Home.route) {
            HomeContainerScreen()
        }

    }
}
