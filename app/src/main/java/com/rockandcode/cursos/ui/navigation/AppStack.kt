package com.rockandcode.cursos.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.rockandcode.cursos.ui.components.BottomBar
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
import com.rockandcode.cursos.ui.screens.MedalScreen
import com.rockandcode.cursos.ui.screens.MyProgressScreen
import com.rockandcode.cursos.ui.screens.ProfileScreen
import com.rockandcode.cursos.ui.screens.SearchScreen
import com.rockandcode.cursos.ui.screens.SearchViewModel
import com.rockandcode.cursos.utils.toCourse

@Composable
fun AppStack(
    controller: NavHostController,
    snackbarHostState: SnackbarHostState,
    onLogout: () -> Unit,
) {
    val navBackStackEntry = controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val hideBottomBarRoutes = listOf("profile", "courseDetail", "search", "filters", "cart", "checkout", "myProgress", "medals")
    val shouldHideBottomBarAndFav =
        hideBottomBarRoutes.any { prefix ->
            currentRoute?.startsWith(prefix) == true
        }

    val cartViewModel: CartViewModel = hiltViewModel()
    val checkoutViewModel: CheckoutViewModel = hiltViewModel()

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
            startDestination = "home",
        ) {
            composable("home") {
                HomeScreen(
                    modifier = Modifier.padding(paddingValue),
                    controller = controller,
                )
            }

            composable("profile") {
                ProfileScreen(controller = controller, onLogout = onLogout)
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
                    onNext = {
                        if (checkoutViewModel.isOnlyFreeCourses()) {
                            controller.navigate("checkout/review")
                        } else {
                            controller.navigate("checkout/payment")
                        }
                    },
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

            composable("medals") {
                MedalScreen(controller = controller)
            }
        }
    }
}
