package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CourseRequirements(requeriments: List<String>) {
    requeriments.forEach { requeriment ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 2.dp),
        ) {
            Text(text = "* $requeriment", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
