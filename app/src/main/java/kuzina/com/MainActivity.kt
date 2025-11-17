package kuzina.com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import kuzina.com.navigation.NavGraph
import kuzina.com.ui.screens.auth.LoginScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val navController = rememberNavController()
//            Surface(color = MaterialTheme.colorScheme.background) {
//                NavGraph(navController = navController)
//            }
            LoginScreen()
        }
    }
}


