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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.Course

@Composable
fun CourseCard(
    course: Course,
    onClick: () -> Unit = {},
) {
    val isDarkTheme = isSystemInDarkTheme()
//    Card(
//        modifier =
//            Modifier
//                .fillMaxWidth()
//                .clickable { onClick() },
//        shape = RoundedCornerShape(12.dp),
//    ) {
//        Column(modifier = Modifier.padding(8.dp)) {
//            AsyncImage(
//                model = course.thumbnailUrl,
//                contentDescription = course.title,
//                modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .height(120.dp)
//                        .clip(RoundedCornerShape(8.dp)),
//                contentScale = ContentScale.Crop,
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(course.title, maxLines = 2)
//            Text("⭐ ${course.rating}", style = MaterialTheme.typography.labelSmall)
//            Text("${course.price} USD", fontWeight = FontWeight.Bold)
//        }
//    }

    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = { onClick() },
                ),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = RoundedCornerShape(12.dp),
        colors =
            CardDefaults.cardColors(
                containerColor = if (!isDarkTheme) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceContainer,
            ),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = course.thumbnailUrl,
                contentDescription = course.title,
                modifier =
                    Modifier
                        .width(130.dp)
                        .height(140.dp)
                        .clip(RoundedCornerShape(bottomStart = 8.dp, topStart = 8.dp)),
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                Text(
                    course.title,
                    style = MaterialTheme.typography.titleSmall,
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    course.subTitle,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                )
                Spacer(Modifier.height(4.dp))
                course.author?.let { author ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Creado por ", style = MaterialTheme.typography.labelSmall)
                        Text(author.name, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
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
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(16.dp),
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    Text(
                        "${"%.1f".format(course.rating)} (${course.ratingCount} valoraciones)",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
                Spacer(Modifier.height(4.dp))
                Text(
                    text = if (!course.isFree) "$${course.price}" else "Gratuito",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}
