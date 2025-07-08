package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.Course

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CourseInstructors(
    course: Course,
    onClick: (Int) -> (Unit),
) {
    val isDarkTheme = isSystemInDarkTheme()
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        Text(
            text = if (course.instructors.size > 1) "Instructores" else "Instructor",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )

        course.instructors.forEach { instructor ->
            Card(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .clickable(onClick = { onClick(instructor.id) })
                        .padding(vertical = 8.dp),
                colors =
                    CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background,
                    ),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp),
                ) {
                    AsyncImage(
                        model = instructor.avatarUrl,
                        contentDescription = instructor.name,
                        modifier =
                            Modifier
                                .size(80.dp)
                                .clip(CircleShape),
                    )
                    Spacer(Modifier.width(8.dp))
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                instructor.name,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(modifier = Modifier.weight(1f))

                            TextButton(
                                onClick = { onClick(instructor.id) },
                                modifier =
                                    Modifier
                                        .background(
                                            color = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primaryContainer,
                                            shape = RoundedCornerShape(24.dp),
                                        ).height(26.dp)
                                        .defaultMinSize(minHeight = 1.dp, minWidth = 1.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                                colors =
                                    ButtonDefaults.textButtonColors(
                                        contentColor = Color.White,
                                    ),
                            ) {
                                Text(
                                    "Ver perfil",
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        if (!instructor.bio.isNullOrEmpty()) {
                            Text(
                                instructor.bio,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Gray,
                            )
                        } else {
                            Text(
                                "Instructor experto",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Gray,
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        instructor.specialization?.let {
                            Text(
                                it,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary,
                            )
                        }
                    }
                }
            }
        }
    }
}
