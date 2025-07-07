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
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rockandcode.cursos.ui.components.BottomBar
import com.rockandcode.cursos.ui.components.Splash
import com.rockandcode.cursos.ui.screens.CartScreen
import com.rockandcode.cursos.ui.screens.CartViewModel
import com.rockandcode.cursos.ui.screens.CheckoutPaymentScreen
import com.rockandcode.cursos.ui.screens.CheckoutReviewScreen
import com.rockandcode.cursos.ui.screens.CheckoutSuccessScreen
import com.rockandcode.cursos.ui.screens.CheckoutUserInfoScreen
import com.rockandcode.cursos.ui.screens.CheckoutViewModel
import com.rockandcode.cursos.ui.screens.CourseDetailScreen
import com.rockandcode.cursos.ui.screens.FiltersScreen
import com.rockandcode.cursos.ui.screens.HomeScreen
import com.rockandcode.cursos.ui.screens.MyProgressScreen
import com.rockandcode.cursos.ui.screens.ProfileScreen
import com.rockandcode.cursos.ui.screens.SearchScreen
import com.rockandcode.cursos.ui.screens.SearchViewModel
import com.rockandcode.cursos.ui.theme.CursosTheme
import com.rockandcode.cursos.utils.toCourse
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
    val isAuthenticated by remember { mutableStateOf(true) }
    val navBackStackEntry = controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val hideBottomBarRoutes = listOf("profile", "courseDetail", "search", "filters", "cart", "checkout", "myProgress")
    val shouldHideBottomBarAndFav =
        hideBottomBarRoutes.any { prefix -> currentRoute?.startsWith(prefix) == true }

    val cartViewModel: CartViewModel = hiltViewModel()
    val checkoutViewModel: CheckoutViewModel = hiltViewModel()

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
                            controller = controller,
                        )
                    }

                    composable("profile") {
                        ProfileScreen(controller = controller)
                    }

                    composable("courseDetail/{courseId}") { backStack ->
                        val courseId = backStack.arguments?.getString("courseId")?.toIntOrNull() ?: return@composable
                        CourseDetailScreen(
                            courseId = courseId,
                            onBack = { controller.popBackStack() },
                            cartViewModel = cartViewModel,
                            checkoutViewModel = checkoutViewModel,
                            controller = controller,
                        )
                    }

                    composable(
                        route = "search?categoryId={categoryId}",
                        arguments =
                            listOf(
                                navArgument("categoryId") {
                                    type = NavType.IntType
                                    defaultValue = -1 // -1 como valor por defecto para "sin categoría"
                                },
                            ),
                    ) {
                        SearchScreen(controller)
                    }

                    composable("search/filters") { backStackEntry ->
                        val parentEntry =
                            remember(backStackEntry) {
                                controller.getBackStackEntry("search?categoryId={categoryId}")
                            }
                        val searchViewModel: SearchViewModel = hiltViewModel(parentEntry)
                        FiltersScreen(controller = controller, searchViewModel = searchViewModel)
                    }

                    composable("cart") {
                        CartScreen(
                            viewModel = cartViewModel,
                            checkoutViewModel = checkoutViewModel,
                            controller = controller,
                            onCheckout = {
                                checkoutViewModel.setCourses(cartViewModel.items.map { it.toCourse() })
                                controller.navigate("checkout/user")
                            },
                        )
                    }

                    composable("checkout/user") {
                        CheckoutUserInfoScreen(
                            viewModel = checkoutViewModel,
                            onBack = { controller.popBackStack() },
                            onNext = { controller.navigate("checkout/payment") },
                        )
                    }

                    composable("checkout/payment") {
                        CheckoutPaymentScreen(
                            viewModel = checkoutViewModel,
                            onNext = { controller.navigate("checkout/review") },
                            onBack = { controller.popBackStack() },
                        )
                    }

                    composable("checkout/review") {
                        CheckoutReviewScreen(
                            viewModel = checkoutViewModel,
                            onConfirm = {
                                controller.navigate("checkout/success")
                                cartViewModel.clearCart()
                                checkoutViewModel.reset()
                            },
                            onBack = { controller.popBackStack() },
                        )
                    }

                    composable("checkout/success") {
                        CheckoutSuccessScreen(
                            onDone = {
                                controller.navigate("home")
                            },
                        )
                    }

                    composable("myProgress") {
                        MyProgressScreen(controller = controller)
                    }
                }
            }
        }
    }
}
