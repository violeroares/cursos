package com.rockandcode.cursos.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.R

private const val DURATION_MS = 1000

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
) {
    var logoVisible by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isDarkTheme = isSystemInDarkTheme()

    LaunchedEffect(Unit) {
        logoVisible = true
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // ZONA AZUL CON FONDO Y CORNER CURVO
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(
                        color =
                            if (isDarkTheme) {
                                MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                            } else {
                                Color(0xFF2B1BBA)
                            },
                        shape = RoundedCornerShape(bottomEnd = 96.dp),
                    ).padding(top = 48.dp, bottom = 64.dp, start = 48.dp, end = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Logo animado
            AnimatedVisibility(
                visible = logoVisible,
                enter =
                    fadeIn(tween(DURATION_MS)) +
                        scaleIn(
                            initialScale = 0.8f,
                            animationSpec =
                                tween(
                                    DURATION_MS,
                                ),
                        ),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                ) {
                    Spacer(modifier = Modifier.height(64.dp))
                    Image(
                        painter =
                            painterResource(
                                id = if (isDarkTheme) R.drawable.logo_acadexa_dark else R.drawable.logo_acadexa_dark,
                            ),
                        contentDescription = "logo",
                        modifier = Modifier.size(height = 90.dp, width = 300.dp),
                    )
                    Text(
                        text = "Aprende. Crece. Destacate",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFC8EE4A),
                        textAlign = TextAlign.Center,
                    )
                }
            }

            Spacer(modifier = Modifier.height(96.dp))

            Text(
                text = "Inicia sesión para comenzar tu aprendizaje",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = "Email Icon")
                },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "Password Icon")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
            )
            // Recuperar contraseña (fuera de zona azul)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "¿Olvidaste tu contraseña?",
                modifier =
                    Modifier
                        .align(Alignment.End)
                        .clickable { onForgotPasswordClick() },
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier =
                Modifier.padding(horizontal = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Botón Login
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { onLoginClick() },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primary,
                        contentColor = if (!isDarkTheme) Color.White else MaterialTheme.colorScheme.onPrimary,
                    ),
            ) {
                Text("Iniciar sesión", fontWeight = FontWeight.SemiBold)
            }

            // Registro
            Spacer(modifier = Modifier.height(24.dp))
            Row {
                Text("¿No tenés una cuenta? ")
                Text(
                    text = "Registrate",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable { onRegisterClick() },
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}
