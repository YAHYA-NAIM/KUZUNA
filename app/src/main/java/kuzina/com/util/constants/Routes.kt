package kuzina.com.util.constants

sealed class Routes(val route: String) {
    object Splash : Routes("splash")
    object Home : Routes("home")
    object Login : Routes("login")
}
