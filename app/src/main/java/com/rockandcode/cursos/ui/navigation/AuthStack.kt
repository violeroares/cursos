package com.rockandcode.cursos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rockandcode.cursos.ui.screens.ForgotPasswordScreen
import com.rockandcode.cursos.ui.screens.LoginScreen
import com.rockandcode.cursos.ui.screens.RegisterScreen

@Composable
fun AuthStack(
    controller: NavHostController,
    onLoginSuccess: () -> Unit,
) {
    NavHost(navController = controller, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginClick = {
                    onLoginSuccess()
                },
                onRegisterClick = { controller.navigate("register") },
                onForgotPasswordClick = { controller.navigate("forgot") },
            )
        }

        composable("register") {
            RegisterScreen(onBack = { controller.popBackStack() })
        }

        composable("forgot") {
            ForgotPasswordScreen(onBack = { controller.popBackStack() })
        }
    }
}
