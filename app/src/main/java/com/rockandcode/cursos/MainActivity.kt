package com.rockandcode.cursos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.rockandcode.cursos.ui.components.Splash
import com.rockandcode.cursos.ui.navigation.AppStack
import com.rockandcode.cursos.ui.navigation.AuthStack
import com.rockandcode.cursos.ui.screens.AuthViewModel
import com.rockandcode.cursos.ui.theme.CursosTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

private const val SPLASH_SCREEN_DELAY_MS = 3000L

fun ComponentActivity.setStatusBarIconsWhite() {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setStatusBarIconsWhite()
        setContent {
            CursosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val controller = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    var showSplash by remember { mutableStateOf(true) }
    val authViewModel: AuthViewModel = hiltViewModel()
    val isAuthenticated by authViewModel.isAuthenticated

    // Esperamos 3s y decidimos a qué pantalla ir
    LaunchedEffect(isAuthenticated) {
        delay(SPLASH_SCREEN_DELAY_MS)
        showSplash = false
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (showSplash) {
            Splash()
        } else {
            if (isAuthenticated) {
                AppStack(controller, snackbarHostState, onLogout = { authViewModel.logout() })
            } else {
                AuthStack(controller, onLoginSuccess = { authViewModel.login("dummy", "dummy") })
            }
        }
    }
}
