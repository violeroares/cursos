package com.rockandcode.cursos.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
    var isFocused by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        logoVisible = true
    }

    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.background),
    ) {
        // Fondo azul con contenido
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(
                        color =
                            if (isDarkTheme) {
                                MaterialTheme.colorScheme.background
                            } else {
                                Color(0xFF2B1BBA)
                            },
                    ).padding(top = 48.dp, bottom = 64.dp, start = 48.dp, end = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AnimatedVisibility(
                visible = logoVisible,
                enter =
                    fadeIn(tween(DURATION_MS)) +
                        scaleIn(
                            initialScale = 0.8f,
                            animationSpec = tween(DURATION_MS),
                        ),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                ) {
                    Image(
                        painter =
                            painterResource(
                                id = if (isDarkTheme) R.drawable.icons_login_top else R.drawable.icons_login_top,
                            ),
                        contentDescription = "logo top",
                        modifier = Modifier.size(height = 90.dp, width = 300.dp),
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Image(
                        painter =
                            painterResource(
                                id = if (isDarkTheme) R.drawable.logo_acadexa_dark else R.drawable.logo_acadexa_dark,
                            ),
                        contentDescription = "logo",
                        modifier = Modifier.size(height = 90.dp, width = 300.dp),
                    )
                    Text(
                        text = "Aprendé. Crecé. Destacáte",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFC8EE4A),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(64.dp))
                    Image(
                        painter =
                            painterResource(
                                id = if (isDarkTheme) R.drawable.icons_login_bottom else R.drawable.icons_login_bottom,
                            ),
                        contentDescription = "logo bottom",
                        modifier = Modifier.size(height = 90.dp, width = 300.dp),
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }

        // Formulario blanco superpuesto
        Column(
            modifier =
                Modifier
                    .align(Alignment.BottomCenter) // 👈 Ancla la columna al fondo de pantalla
                    .fillMaxWidth()
                    .background(
                        color =
                            if (isDarkTheme) {
                                MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                            } else {
                                MaterialTheme.colorScheme.background
                            },
                        shape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp),
                    ).padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Inicia sesión para comenzar tu aprendizaje",
                color = if (!isDarkTheme) Color(0xFF2B1BBA) else MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(25.dp))

            // Email
            val enabled = true
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .shadow(8.dp, shape = RoundedCornerShape(50))
                        .background(Color.White, shape = RoundedCornerShape(50))
                        .border(
                            width = 1.dp,
                            color = if (isFocused) Color(0xFF7B2FC5) else Color.LightGray,
                            shape = RoundedCornerShape(50),
                        ).padding(horizontal = 14.dp, vertical = 10.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier =
                            Modifier
                                .size(30.dp) // tamaño del círculo
                                .background(
                                    color = Color(0xFFF2E7FE),
                                    shape = CircleShape,
                                ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email Icon",
                            tint = Color(0xFF7B2FC5),
                            modifier = Modifier.size(20.dp),
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    BasicTextField(
                        value = email,
                        onValueChange = { email = it },
                        enabled = enabled,
                        textStyle =
                            MaterialTheme.typography.bodyLarge.copy(
                                color = if (enabled) Color.Black else Color.Gray,
                            ),
                        singleLine = true,
                        modifier =
                            Modifier
                                .weight(1f)
                                .onFocusChanged { isFocused = it.isFocused },
                        decorationBox = { innerTextField ->
                            if (email.isEmpty()) {
                                Text(
                                    text = "Email",
                                    style = TextStyle(color = Color.Gray),
                                )
                            }
                            innerTextField()
                        },
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Password
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .shadow(8.dp, shape = RoundedCornerShape(50))
                        .background(Color.White, shape = RoundedCornerShape(50))
                        .border(
                            width = 1.dp,
                            color = if (isFocused) Color(0xFF7B2FC5) else Color.LightGray,
                            shape = RoundedCornerShape(50),
                        ).padding(horizontal = 14.dp, vertical = 10.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier =
                            Modifier
                                .size(30.dp) // tamaño del círculo
                                .background(
                                    color = Color(0xFFF2E7FE),
                                    shape = CircleShape,
                                ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password Icon",
                            tint = Color(0xFF7B2FC5),
                            modifier = Modifier.size(20.dp),
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    BasicTextField(
                        value = password,
                        onValueChange = { password = it },
                        enabled = enabled,
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        textStyle =
                            MaterialTheme.typography.bodyLarge.copy(
                                color = if (enabled) Color.Black else Color.Gray,
                            ),
                        singleLine = true,
                        modifier =
                            Modifier
                                .weight(1f)
                                .onFocusChanged { isFocused = it.isFocused },
                        decorationBox = { innerTextField ->
                            if (password.isEmpty()) {
                                Text(
                                    text = "Contraseña",
                                    style = TextStyle(color = Color.Gray),
                                )
                            }
                            innerTextField()
                        },
                    )
                }
            }

            // Recuperar contraseña
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "¿Olvidaste tu contraseña?",
                modifier =
                    Modifier
                        .align(Alignment.End)
                        .clickable { onForgotPasswordClick() },
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = if (!isDarkTheme) Color(0xFF2B1BBA) else MaterialTheme.colorScheme.onBackground,
            )

            // Botón Login
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = { onLoginClick() },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                shape = RoundedCornerShape(24.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primary,
                        contentColor = if (!isDarkTheme) Color.White else MaterialTheme.colorScheme.onPrimary,
                    ),
            ) {
                Text("Iniciar sesión", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyLarge)
            }

            // Registro
            Spacer(modifier = Modifier.height(24.dp))
            Row {
                Text("¿No tenés una cuenta? ")
                Text(
                    text = "Registrate",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable { onRegisterClick() },
                )
            }
        }
    }
}
