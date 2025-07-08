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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.ui.components.AppHeader
import com.rockandcode.cursos.utils.formatPrice

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

            // Datos del usuario
            Text(
                text = "Datos del usuario",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = if (!isDarkTheme) Color(0xFF2B1BBA) else MaterialTheme.colorScheme.onBackground,
            )

            Text(" Nombre: ${viewModel.userInfo.name}")
            Text(" Email: ${viewModel.userInfo.email}")

            Spacer(Modifier.height(16.dp))

            // Datos de la tarjeta
            Text(
                text = "Datos de la tarjeta",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = if (!isDarkTheme) Color(0xFF2B1BBA) else MaterialTheme.colorScheme.onBackground,
            )
            Text(" Tarjeta: **** **** **** ${viewModel.paymentInfo.cardNumber.takeLast(4)}")

            Spacer(Modifier.height(16.dp))

            // Detalle de la compra
            Text(
                text = "Cursos",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = if (!isDarkTheme) Color(0xFF2B1BBA) else MaterialTheme.colorScheme.onBackground,
            )
            viewModel.coursesToBuy.forEach {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        AsyncImage(
                            model = it.thumbnailUrl,
                            contentDescription = null,
                            modifier =
                                Modifier
                                    .size(height = 64.dp, width = 80.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop,
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(it.title, fontWeight = FontWeight.Bold)
                            Text(
                                text = formatPrice(it.price),
                                fontWeight = FontWeight.SemiBold,
                                color = if (isDarkTheme) Color.LightGray else Color.DarkGray,
                            )
                        }
                    }
                }
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    "Total: ${formatPrice(total)}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Spacer(Modifier.height(24.dp))
            Text(
                text = "Verifique que todos los datos sean correctos y confirme la compra",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = if (isDarkTheme) Color.LightGray else Color.DarkGray,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Button(
                onClick = onConfirm,
                modifier =
                    Modifier
                        .fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primary,
                        contentColor = if (!isDarkTheme) Color.White else MaterialTheme.colorScheme.onPrimary,
                    ),
            ) {
                Text("Confirmar compra", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyLarge)
            }

            TextButton(onClick = onBack) {
                Text("Volver")
            }
        }
    }
}
