package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.domain.models.Course

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CourseTags(
    course: Course,
    onClick: (String) -> (Unit),
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        Text(
            "Temas relacionados",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            course.tags.forEach { tag ->
                FilterChip(
                    selected = false,
                    onClick = { onClick(tag) },
                    label = { Text(tag) },
                )
            }
        }
    }
}
