package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.Course

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
                .width(250.dp)
                .height(280.dp) // fijo para que la mitad vertical tenga sentido
                .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = RoundedCornerShape(16.dp),
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

                Text(
                    text = "⭐ ${course.rating} · ${course.description.take(40)}",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Author: ${course.author?.name ?: "Desconocido"}",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "${course.price} USD",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    )
//                    if (!isPurchased) {
//                        OutlinedButton(
//                            onClick = { /* acción Inscribirse */ },
//                            // ancho mínimo estándar
//                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp), // vertical menor
//                        ) {
//                            Text(text = "Ver curso")
//                        }
//                    } else {
//                        Text(
//                            text = "Ya lo tienes!",
//                            style = MaterialTheme.typography.bodyMedium,
//                            color = MaterialTheme.colorScheme.primary,
//                            modifier = Modifier.padding(vertical = 4.dp),
//                        )
//                    }
                }
            }
        }
    }
}
