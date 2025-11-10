package kuzina.com.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kuzina.com.ui.screens.home.HomeScreen
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

        composable(Routes.Home.route) {
            HomeScreen()
        }

        composable(Routes.Login.route) {

        }
    }
}
