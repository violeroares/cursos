package com.rockandcode.cursos.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rockandcode.cursos.R

private const val DURATION_MS = 1000

@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    val state by viewModel.uiState.collectAsState()
    var logoVisible by remember { mutableStateOf(false) }
    val isDarkTheme = isSystemInDarkTheme()
    var isFocused by remember { mutableStateOf(false) }

    when (val uiState = state) {
        is ForgotPasswordUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is ForgotPasswordUiState.Error -> {
            Text("Error: ${uiState.message}")
        }

        is ForgotPasswordUiState.Success -> {
            var email = uiState.email
            LaunchedEffect(Unit) {
                logoVisible = true
            }

            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(if (isDarkTheme) MaterialTheme.colorScheme.background else Color(0xFF2B1BBA)),
            ) {
                Column(
                    modifier =
                        Modifier
                            .align(Alignment.TopCenter),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    AnimatedVisibility(
                        visible = logoVisible,
                        enter = fadeIn(tween(DURATION_MS)) + scaleIn(initialScale = 0.8f, animationSpec = tween(DURATION_MS)),
                    ) {
                        Column(
                            modifier =
                                Modifier.padding(top = 65.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Image(
                                painter =
                                    painterResource(
                                        id = if (isDarkTheme) R.drawable.logo_acadexa_dark else R.drawable.logo_acadexa_dark,
                                    ),
                                contentDescription = "logo",
                                modifier =
                                    Modifier
                                        .size(height = 54.dp, width = 180.dp),
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Recuperar contraseña",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFFC8EE4A),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(0.dp),
                            )
                        }
                    }
                }

                //  Sección blanca alineada al fondo
                Column(
                    modifier =
                        Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .background(
                                color =
                                    if (isDarkTheme) {
                                        MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                                    } else {
                                        MaterialTheme.colorScheme.background
                                    },
                                shape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp),
                            ).padding(horizontal = 30.dp, vertical = 40.dp),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text =
                            "Ingrese su email para recuperar su contraseña, " +
                                "un mensaje le será enviado para terminar el proceso de recuperación",
                        style = MaterialTheme.typography.titleSmall.copy(lineHeight = 18.sp),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp),
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    //  Campo Email
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
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier =
                                    Modifier
                                        .size(30.dp)
                                        .background(Color(0xFFF2E7FE), shape = CircleShape),
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
                                        Text(text = "Email", style = TextStyle(color = Color.Gray))
                                    }
                                    innerTextField()
                                },
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(45.dp))

                    //  Botones
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        OutlinedButton(
                            onClick = onBack,
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(24.dp),
                            border = BorderStroke(1.dp, if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primary),
                        ) {
                            Text("Cancelar", fontWeight = FontWeight.SemiBold, maxLines = 1)
                        }

                        Button(
                            onClick = onBack,
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(24.dp),
                            colors =
                                ButtonDefaults.buttonColors(
                                    containerColor = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primary,
                                    contentColor = if (!isDarkTheme) Color.White else MaterialTheme.colorScheme.onPrimary,
                                ),
                        ) {
                            Text("Recuperar", fontWeight = FontWeight.SemiBold, maxLines = 1)
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
            }
        }
    }
}
