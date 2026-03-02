package kuzina.com.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kuzina.com.ui.screens.home.FavorisTabScreen
import kuzina.com.ui.screens.home.HomeTabScreen
import kuzina.com.ui.screens.home.ProfileTabScreen
import kuzina.com.util.constants.Routes

@Composable
fun HomeNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Routes.HomeTab.route,
        modifier = modifier
    ) {
        composable(Routes.HomeTab.route) { HomeTabScreen() }
        composable(Routes.FavorisTab.route) { FavorisTabScreen() }
        composable(Routes.ProfileTab.route) { ProfileTabScreen() }
    }
}