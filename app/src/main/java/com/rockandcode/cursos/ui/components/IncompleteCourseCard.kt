package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.clickable
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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.Course

@Composable
fun IncompleteCourseCard(
    course: Course,
    percent: Double,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
//    Card(
//        modifier =
//            modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//                .clickable { onClick() },
//        colors = CardDefaults.cardColors(containerColor = Color(0xFFEEF6FD)),
//        elevation = CardDefaults.cardElevation(4.dp),
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text("¡Seguí aprendiendo!", style = MaterialTheme.typography.titleMedium)
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(course.title, style = MaterialTheme.typography.bodyMedium)
//            Spacer(modifier = Modifier.height(12.dp))
//            LinearProgressIndicator(
//                progress = (percent / 100.0).toFloat(),
//                modifier = Modifier.fillMaxWidth(),
//                color = Color(0xFF1976D2),
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text("${percent.toInt()}% completado", style = MaterialTheme.typography.labelSmall)
//        }
//    }

    Card(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clickable(
                    onClick = { onClick() },
                ),
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = course.thumbnailUrl,
                contentDescription = course.title,
                modifier =
                    Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    course.title,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(vertical = 4.dp),
                )
                Spacer(modifier = Modifier.height(12.dp))
                LinearProgressIndicator(
                    progress = { (percent / 100.0).toFloat() },
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFF1976D2),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text("${percent.toInt()}% completado", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}
