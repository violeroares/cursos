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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.ui.components.AppHeader
import com.rockandcode.cursos.utils.getCardBrandUrl

@Composable
fun CheckoutPaymentScreen(
    viewModel: CheckoutViewModel,
    onNext: () -> Unit,
    onBack: () -> Unit,
) {
    var cardNumber by remember { mutableStateOf(viewModel.paymentInfo.cardNumber) }
    var expiry by remember { mutableStateOf(viewModel.paymentInfo.expiry) }
    var cvv by remember { mutableStateOf(viewModel.paymentInfo.cvv) }
    var holder by remember { mutableStateOf(viewModel.paymentInfo.holderName) }
    var dni by remember { mutableStateOf("") }
    val isDarkTheme = isSystemInDarkTheme()

    val cardBrandUrl by remember(cardNumber) {
        mutableStateOf(getCardBrandUrl(cardNumber))
    }

    Scaffold(
        topBar = {
            AppHeader(
                title = "Datos de la tarjeta",
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

            // Número de tarjeta con logo detectado
            OutlinedTextField(
                value = cardNumber,
                onValueChange = { cardNumber = it },
                label = { Text("Número de tarjeta") },
                placeholder = { Text("Ej.: 1234 1234 1234 1234") },
                trailingIcon = {
                    AsyncImage(
                        model = cardBrandUrl,
                        contentDescription = "Marca de tarjeta",
                        modifier = Modifier.size(40.dp).padding(end = 4.dp),
                    )
                },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.height(12.dp))

            OutlinedTextField(
                value = holder,
                onValueChange = { holder = it },
                label = { Text("Nombre del titular") },
                placeholder = { Text("Ej.: María López") },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                OutlinedTextField(
                    value = expiry,
                    onValueChange = { expiry = it },
                    label = { Text("Venc. (MM/AA)") },
                    modifier = Modifier.weight(1f),
                )

                OutlinedTextField(
                    value = cvv,
                    onValueChange = { cvv = it },
                    label = { Text("Cód. de Seguridad") },
                    placeholder = { Text("Ej.: 123") },
                    modifier = Modifier.weight(1f),
                )
            }

            Spacer(Modifier.height(12.dp))

            OutlinedTextField(
                value = dni,
                onValueChange = { dni = it },
                label = { Text("DNI") },
                placeholder = { Text("Ej.: 99.999.999") },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    viewModel.paymentInfo = PaymentInfo(cardNumber, expiry, cvv, holder)
                    onNext()
                },
                modifier =
                    Modifier
                        .fillMaxWidth(),
                enabled = listOf(cardNumber, expiry, cvv, holder, dni).all { it.isNotBlank() },
                shape = RoundedCornerShape(24.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primary,
                        contentColor = if (!isDarkTheme) Color.White else MaterialTheme.colorScheme.onPrimary,
                    ),
            ) {
                Text("Continuar al resumen", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyLarge)
            }

            TextButton(onClick = onBack) {
                Text("Volver")
            }
        }
    }
}
