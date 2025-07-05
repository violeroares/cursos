package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.domain.models.Course

@Composable
fun CoursePurchaseButton(course: Course) {
    val isDarkTheme = isSystemInDarkTheme()
    Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)) {
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = "Valor del curso",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = if (!course.isFree) "$${course.price}" else "Gratuito",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(Modifier.height(12.dp))
        TextButton(
            onClick = { /* Comprar */ },
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(
                        color = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(24.dp),
                    ),
            colors =
                ButtonDefaults.textButtonColors(
                    contentColor = if (!isDarkTheme) Color.White else MaterialTheme.colorScheme.onPrimary,
                ),
        ) {
            Text(
                "Inscribirme ahora",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}
