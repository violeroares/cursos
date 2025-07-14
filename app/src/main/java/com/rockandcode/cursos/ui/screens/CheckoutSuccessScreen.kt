package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.R

@Composable
fun CheckoutSuccessScreen(onDone: () -> Unit) {
    val isDarkTheme = isSystemInDarkTheme()
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color(0xFF2B1BBA), shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(Modifier.height(24.dp))
        Image(
            painter =
                painterResource(
                    id = if (isDarkTheme) R.drawable.logo_acadexa_dark else R.drawable.logo_acadexa_dark,
                ),
            contentDescription = "logo",
            modifier = Modifier.height(32.dp),
        )
//        Text(
//            text = "¡Compra realizada con éxito!",
//            style = MaterialTheme.typography.titleLarge,
//            fontWeight = FontWeight.SemiBold,
//            color = Color.White,
//        )
        Spacer(Modifier.height(24.dp))
        Icon(
            Icons.Rounded.CheckCircle,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(180.dp),
        )
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
//        Icon(
//            Icons.Outlined.CheckCircle,
//            contentDescription = null,
//            tint = Color(0xFF2B1BBA),
//            modifier = Modifier.size(96.dp),
//        )
//        Spacer(Modifier.height(16.dp))
        Text("¡Compra realizada con éxito!", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(32.dp))

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = onDone,
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
                Text("Ir a inicio", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
