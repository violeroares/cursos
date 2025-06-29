package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rockandcode.cursos.ui.components.Avatar
import com.rockandcode.cursos.ui.components.CustomHeader

@Composable
fun ProfileScreen(controller: NavHostController) {
    Scaffold(
        topBar = {
            CustomHeader(title = "Mi perfil", onBack = { controller.popBackStack() })
        },
        contentWindowInsets = WindowInsets.statusBars,
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Avatar(
                avatarUrl = "https://ui-avatars.com/api/?name=Jhon+Doe",
                avatarSize = 110.dp,
            )
        }
    }
}
