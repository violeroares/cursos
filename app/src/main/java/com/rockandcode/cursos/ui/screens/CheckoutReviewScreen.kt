package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.ui.components.AppHeader

@Composable
fun CheckoutReviewScreen(
    viewModel: CheckoutViewModel,
    onConfirm: () -> Unit,
    onBack: () -> Unit,
) {
    val isDarkTheme = isSystemInDarkTheme()
    val total = viewModel.coursesToBuy.sumOf { it.price }

    Scaffold(
        topBar = {
            AppHeader(
                title = "Resumen de compra",
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

            Text("Usuario: ${viewModel.userInfo.name} - ${viewModel.userInfo.email}")
            Text("Tarjeta: **** **** **** ${viewModel.paymentInfo.cardNumber.takeLast(4)}")
            Spacer(Modifier.height(16.dp))

            Text("Cursos:")
            viewModel.coursesToBuy.forEach {
                Text("- ${it.title} ($${"%.2f".format(it.price)})")
            }

            Spacer(Modifier.height(16.dp))
            Text("Total: $${"%.2f".format(total)}", fontWeight = FontWeight.Bold)

            Spacer(Modifier.height(24.dp))
            Button(
                onClick = onConfirm,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primary,
                        contentColor = if (!isDarkTheme) Color.White else MaterialTheme.colorScheme.onPrimary,
                    ),
            ) {
                Text("Confirmar compra", fontWeight = FontWeight.SemiBold)
            }

            TextButton(onClick = onBack) {
                Text("Volver")
            }
        }
    }
}
