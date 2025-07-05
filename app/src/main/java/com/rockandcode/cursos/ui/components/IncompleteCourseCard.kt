package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
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
fun IncompleteCourseCard(
    course: Course,
    percent: Double,
    onClick: () -> Unit,
) {
    val isDarkTheme = isSystemInDarkTheme()
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 16.dp)
                .clickable(
                    onClick = { onClick() },
                ),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = RoundedCornerShape(12.dp),
        colors =
            CardDefaults.cardColors(
                containerColor =
                    if (!isDarkTheme) {
                        MaterialTheme.colorScheme.surface
                    } else {
                        MaterialTheme.colorScheme.surfaceContainer
                    },
            ),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = course.thumbnailUrl,
                contentDescription = course.title,
                modifier =
                    Modifier
                        .width(85.dp)
                        .height(85.dp)
                        .clip(RoundedCornerShape(bottomStart = 8.dp, topStart = 8.dp)),
                contentScale = ContentScale.Crop,
            )

            Column(modifier = Modifier.padding(12.dp)) {
                Text(course.title, fontWeight = FontWeight.SemiBold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Progreso:",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                    )
                    Text(
                        text = "%.1f%%".format(percent),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                    )
                }
                LinearProgressIndicator(
                    progress = { (percent / 100.0).toFloat() },
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                )
            }
        }
    }

//    Card(
//        modifier =
//            modifier
//                .fillMaxWidth()
//                .padding(vertical = 4.dp)
//                .clickable(
//                    onClick = { onClick() },
//                ),
//        colors =
//            CardDefaults.cardColors(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//            ),
//        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
//        shape = RoundedCornerShape(16.dp),
//    ) {
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            AsyncImage(
//                model = course.thumbnailUrl,
//                contentDescription = course.title,
//                modifier =
//                    Modifier
//                        .width(100.dp)
//                        .height(100.dp)
//                        .clip(RoundedCornerShape(8.dp)),
//                contentScale = ContentScale.Crop,
//            )
//            Column(modifier = Modifier.padding(12.dp)) {
//                Text(
//                    course.title,
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.padding(vertical = 4.dp),
//                )
//                Spacer(modifier = Modifier.height(12.dp))
//                LinearProgressIndicator(
//                    progress = { (percent / 100.0).toFloat() },
//                    modifier = Modifier.fillMaxWidth(),
//                    color = Color(0xFF1976D2),
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text("${percent.toInt()}% completado", style = MaterialTheme.typography.labelSmall)
//            }
//        }
//    }
}
