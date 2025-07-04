package com.rockandcode.cursos.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.R

private const val DURATION_MS = 1000

@Composable
fun Splash() {
    val isDarkTheme = isSystemInDarkTheme()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        var logoVisible by remember { mutableStateOf(false) }
        var contentVisible by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            logoVisible = true
            contentVisible = true
        }
        // Logo animado
        AnimatedVisibility(
            visible = logoVisible,
            enter =
                fadeIn(animationSpec = tween(DURATION_MS)) +
                    scaleIn(initialScale = 0.8f, animationSpec = tween(DURATION_MS)),
        ) {
            Image(
                painterResource(
                    id = if (isDarkTheme) R.drawable.logo_acadexa_dark else R.drawable.logo_acadexa_light,
                ),
                contentDescription = "logo",
                Modifier.size(180.dp),
            )
        }
    }
}
