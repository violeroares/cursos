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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.models.UserCourseProgress
import com.rockandcode.cursos.utils.formatDuration

@Composable
fun CourseVideos(
    course: Course,
    userProgress: UserCourseProgress?,
    isPurchased: Boolean,
    onClick: (Int, Int) -> (Unit),
) {
    val watchedVideoIds = userProgress?.videoProgress?.map { it.videoId } ?: emptyList()
    val videosToShow =
        if (isPurchased) {
            course.items
        } else {
            course.items.filter { it.isPreview }
        }.sortedBy { it.order }

    val totalSeconds = course.items.sumOf { it.durationSeconds }
    val totalDurationFormatted = formatDuration(totalSeconds)

    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        Text(
            "Contenido del curso:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        Text(
            "4 secciones - ${course.items.count()} videos - $totalDurationFormatted de duración",
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(Modifier.height(8.dp))
        videosToShow.forEach { video ->
            val isWatched = watchedVideoIds.contains(video.id)
            Card(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable(
                            enabled = isPurchased,
                            onClick = { onClick(course.id, video.id) },
                        ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors =
                    CardDefaults.cardColors(
                        containerColor =
                            if (isWatched) {
                                MaterialTheme.colorScheme.primaryContainer
                            } else {
                                MaterialTheme.colorScheme.surfaceVariant
                            },
                    ),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = course.thumbnailUrl,
                        contentDescription = course.title,
                        modifier =
                            Modifier
                                .width(129.dp)
                                .height(129.dp)
                                .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)),
                        contentScale = ContentScale.Crop,
                    )
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            video.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 4.dp),
                            maxLines = 2,
                        )
                        Text(
                            "Duración: ${formatDuration(video.durationSeconds)}",
                            style = MaterialTheme.typography.bodySmall,
                        )

                        if (isPurchased && isWatched) {
                            Text(
                                "✅  Visto",
                                color = Color.Green,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.padding(vertical = 8.dp),
                            )
                        }

                        if (!isPurchased && video.isPreview) {
                            Text(
                                "🎬 Vista previa",
                                color = Color.Blue,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.padding(top = 8.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}
