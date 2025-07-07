package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.ui.components.AppHeader

@Composable
fun CheckoutReviewScreen(
    viewModel: CheckoutViewModel,
    onConfirm: () -> Unit,
    onBack: () -> Unit,
) {
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
            Button(onClick = onConfirm, modifier = Modifier.fillMaxWidth()) {
                Text("Confirmar compra")
            }

            TextButton(onClick = onBack) {
                Text("Volver")
            }
        }
    }
}
