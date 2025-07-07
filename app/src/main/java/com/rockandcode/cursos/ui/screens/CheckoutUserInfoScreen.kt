package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.ui.components.AppHeader

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

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre completo") },
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico") },
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Teléfono") },
                placeholder = { Text("Ej.: 11 1234 5678") },
                modifier = Modifier.fillMaxWidth(),
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                OutlinedTextField(
                    value = street,
                    onValueChange = { street = it },
                    label = { Text("Calle") },
                    modifier = Modifier.weight(1f),
                )

                OutlinedTextField(
                    value = number,
                    onValueChange = { number = it },
                    label = { Text("Número") },
                    modifier = Modifier.weight(1f),
                )
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
                modifier = Modifier.fillMaxWidth(),
                enabled = listOf(name, email, phone, street, number).all { it.isNotBlank() },
            ) {
                Text("Continuar al pago")
            }
        }
    }
}
