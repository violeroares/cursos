package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.ui.components.AppHeader
import com.rockandcode.cursos.ui.components.RoundedTextInput
import com.rockandcode.cursos.ui.components.TextInput

@Composable
fun CheckoutUserInfoScreen(
    viewModel: CheckoutViewModel,
    onNext: () -> Unit,
    onBack: () -> Unit,
) {
    var name by remember { mutableStateOf(viewModel.userInfo.name) }
    var email by remember { mutableStateOf(viewModel.userInfo.email) }
    var phone by remember { mutableStateOf(viewModel.userInfo.phoneNumber) }
    var street by remember { mutableStateOf(viewModel.userInfo.addressStreet) }
    var number by remember { mutableStateOf(viewModel.userInfo.addressNumber) }
    val isDarkTheme = isSystemInDarkTheme()

    Scaffold(
        topBar = {
            AppHeader(
                title = "Datos del usuario",
                onBack = onBack,
            )
        },
        contentWindowInsets = WindowInsets(0),
    ) { paddingValues ->
        Column(
            modifier =
                Modifier
                    .padding(paddingValues)
                    .padding(16.dp),
        ) {
            Spacer(Modifier.height(16.dp))

            TextInput(title = "Nombre")
            Spacer(Modifier.height(6.dp))
            RoundedTextInput(name, { name = it }, "Nombre completo")

            Spacer(Modifier.height(2.dp))

            TextInput(title = "Email")
            Spacer(Modifier.height(6.dp))
            RoundedTextInput(email, { email = it }, "Email")

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

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    viewModel.userInfo =
                        viewModel.userInfo.copy(
                            name = name,
                            email = email,
                            phoneNumber = phone,
                            addressStreet = street,
                            addressNumber = number,
                        )
                    onNext()
                },
                modifier =
                    Modifier
                        .fillMaxWidth(),
                enabled = listOf(name, email, phone, street, number).all { it.isNotBlank() },
                shape = RoundedCornerShape(24.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primary,
                        contentColor = if (!isDarkTheme) Color.White else MaterialTheme.colorScheme.onPrimary,
                    ),
            ) {
                Text("Continuar al pago", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
