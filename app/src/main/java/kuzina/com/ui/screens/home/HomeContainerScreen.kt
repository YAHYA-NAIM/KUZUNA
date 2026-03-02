package kuzina.com.ui.screens.home


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kuzina.com.navigation.HomeNavGraph

@Composable
fun HomeContainerScreen() {
    val navController = rememberNavController()

    // Observe the current back stack entry
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedRoute = navBackStackEntry?.destination?.route ?: "home_tab"

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        HomeNavGraph(navController = navController, modifier = Modifier.weight(1f))

        CurvedBottomBar(
            selectedRoute = selectedRoute,
            onNavigate = { navController.navigate(it) }
        )
    }
}

