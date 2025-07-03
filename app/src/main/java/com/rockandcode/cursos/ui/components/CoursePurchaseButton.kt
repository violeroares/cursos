package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.domain.models.Course

@Composable
fun CoursePurchaseButton(course: Course) {
    Column(modifier = Modifier.padding(16.dp)) {
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
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = { /* Comprar */ },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Inscribirme ahora")
        }
    }
}
