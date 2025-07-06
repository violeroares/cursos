package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.utils.formatPrice

@Composable
fun HomeCourseCard(
    course: Course,
    onClick: () -> Unit = {},
    // isPurchased: Boolean = false,
) {
    val isDarkTheme = isSystemInDarkTheme()
    Card(
        modifier =
            Modifier
                .width(280.dp)
                .height(230.dp) // fijo para que la mitad vertical tenga sentido
                .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        colors =
            CardDefaults.cardColors(
                containerColor = if (!isDarkTheme) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceContainer,
            ),
    ) {
        Column {
            // Imagen sin padding que ocupa la mitad superior
            AsyncImage(
                model = course.thumbnailUrl,
                contentDescription = course.title,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .weight(1f) // mitad vertical
                        .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                contentScale = ContentScale.Crop,
            )

            // Mitad inferior con contenido
            Column(
                modifier =
                    Modifier
                        .weight(1f) // mitad vertical
                        .padding(horizontal = 12.dp, vertical = 8.dp),
            ) {
                Text(
                    text = course.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Stars
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    // 1. Rating numérico
                    Text(
                        text = "%.1f".format(course.rating),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 6.dp),
                        color = Color(0xFFF7C33F),
                    )

                    // 2. Estrellas
                    repeat(5) { index ->
                        val icon =
                            if (index < course.rating.toInt()) {
                                Icons.Filled.Star
                            } else {
                                Icons.Outlined.StarBorder
                            }

                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = Color(0xFFF7C33F),
                            modifier = Modifier.size(16.dp),
                        )
                    }

                    // 3. Valoraciones
                    Text(
                        text = " (${course.totalStudents} estudiantes)",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 4.dp),
                    )
                }

//                Text(
//                    text = "⭐ ${course.rating} · ${course.description.take(40)}",
//                    style = MaterialTheme.typography.bodyMedium,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis,
//                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = course.author?.name ?: "Desconocido",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = if (!course.isFree) formatPrice(course.price) else "Gratuito",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                )
            }
        }
    }
}
