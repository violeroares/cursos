package com.rockandcode.cursos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rockandcode.cursos.ui.components.BottomBar
import com.rockandcode.cursos.ui.components.Splash
import com.rockandcode.cursos.ui.screens.HomeScreen
import com.rockandcode.cursos.ui.screens.ProfileScreen
import com.rockandcode.cursos.ui.theme.CursosTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

private const val SPLASH_SCREEN_DELAY_MS = 3000L

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
    val isAuthenticated by remember { mutableStateOf(true) }
    val navBackStackEntry = controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val hideBottomBarRoutes = listOf("profile", "courseDetail")
    val shouldHideBottomBarAndFav =
        hideBottomBarRoutes.any { prefix -> currentRoute?.startsWith(prefix) == true }

    // Esperamos 3s y decidimos a qué pantalla ir
    LaunchedEffect(isAuthenticated) {
        delay(SPLASH_SCREEN_DELAY_MS)
        showSplash = false
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (showSplash) {
            Splash()
        } else {
            Scaffold(
                bottomBar = {
                    if (!shouldHideBottomBarAndFav) {
                        BottomBar(controller = controller)
                    }
                },
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            ) { paddingValue ->
                NavHost(
                    navController = controller,
                    startDestination = if (isAuthenticated) "home" else "login",
                ) {
                    composable("home") {
                        HomeScreen(
                            modifier = Modifier.padding(paddingValue),
                            // controller = controller,
                        )
                    }

                    composable("profile") {
                        ProfileScreen(controller = controller)
                    }
                }
            }
        }
    }
}
