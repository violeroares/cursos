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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.R
import com.rockandcode.cursos.ui.components.RoundedTextInput
import com.rockandcode.cursos.ui.components.TextInput

private const val DURATION_MS = 1000

@Composable
fun RegisterScreen(onBack: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var street by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var logoVisible by remember { mutableStateOf(false) }
    val isDarkTheme = isSystemInDarkTheme()

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
                        text = "Registro de usuario",
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
            // ACA VAN: Inputs de registro
            TextInput(title = "Email")
            Spacer(Modifier.height(6.dp))
            RoundedTextInput(email, { email = it }, "Email", Icons.Default.Edit, "Editar email")

            Spacer(Modifier.height(2.dp))

            TextInput(title = "Nombre y apellido")
            Spacer(Modifier.height(6.dp))
            RoundedTextInput(name, { name = it }, "Nombre y apellido", Icons.Default.Edit, "Editar nombre y apellido")

            Spacer(Modifier.height(2.dp))

            TextInput(title = "Contraseña")
            Spacer(Modifier.height(6.dp))
            RoundedTextInput(password, { password = it }, "Contraseña", Icons.Default.VisibilityOff, "Editar contraseña")

            Spacer(Modifier.height(2.dp))

            TextInput(title = "Confirmar contraseña")
            Spacer(Modifier.height(6.dp))
            RoundedTextInput(
                confirmPassword,
                { confirmPassword = it },
                "Confirmar contraseña",
                Icons.Default.VisibilityOff,
                "Editar Confirmar contraseña",
            )

            Spacer(Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    TextInput(title = "Fecha de nacimiento")
                    Spacer(Modifier.height(6.dp))
                    RoundedTextInput(birthDate, { birthDate = it }, "Fecha de nac.", Icons.Default.CalendarMonth, "Editar fecha")
                }
                Column(modifier = Modifier.weight(1f)) {
                    TextInput(title = "Género")
                    Spacer(Modifier.height(6.dp))
                    RoundedTextInput(gender, { gender = it }, "Femenino", Icons.Default.KeyboardArrowDown, "Editar género")
                }
            }

            Spacer(Modifier.height(2.dp))

            TextInput(title = "Teléfono")
            Spacer(Modifier.height(6.dp))
            RoundedTextInput(phone, { phone = it }, "Teléfono", Icons.Default.Edit, "Editar teléfono")

            Spacer(Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    TextInput(title = "Calle")
                    Spacer(Modifier.height(6.dp))
                    RoundedTextInput(street, { street = it }, "Calle", Icons.Default.Edit, "Editar calle")
                }
                Column(modifier = Modifier.weight(1f)) {
                    TextInput(title = "Número")
                    Spacer(Modifier.height(6.dp))
                    RoundedTextInput(number, { number = it }, "Número", Icons.Default.Edit, "Editar número")
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
                    Text("Registrarme", fontWeight = FontWeight.SemiBold, maxLines = 1)
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}
