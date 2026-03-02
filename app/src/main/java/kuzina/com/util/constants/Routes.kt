package kuzina.com.util.constants

sealed class Routes(val route: String) {
    object Splash : Routes("splash")
    object Home : Routes("home")
    object Login : Routes("login")

    object SignUp : Routes("SignUp")
    object Onboarding : Routes("onboarding")

    object HomeTab : Routes("home_tab")
    object FavorisTab : Routes("favoris_tab")
    object ProfileTab : Routes("profile_tab")
}
