package com.rockandcode.cursos.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.models.UserCourseProgress
import com.rockandcode.cursos.utils.formatDuration

@Composable
fun CourseVideos(
    course: Course,
    userProgress: UserCourseProgress?,
    isPurchased: Boolean,
    onClick: (Int, Int) -> Unit,
) {
    val isDarkTheme = isSystemInDarkTheme()
    val watchedVideoIds = userProgress?.videoProgress?.map { it.videoId } ?: emptyList()
//    val totalVideos =
//        course.sections.sumOf { section ->
//            section.videos.count { isPurchased || it.isPreview }
//        }

    val totalVideos =
        course.sections.sumOf { section ->
            section.videos.size
        }
    val totalSeconds =
        course.sections.sumOf { section ->
            section.videos.sumOf { it.durationSeconds }
        }
    val totalDurationFormatted = formatDuration(totalSeconds)

    val expandedMap = remember { mutableStateMapOf<Int, Boolean>() }

    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        Text(
            "Contenido del curso:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        Text(
            "${course.sections.size} secciones - $totalVideos videos - $totalDurationFormatted de duración",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
        )
        Spacer(Modifier.height(8.dp))

        course.sections
            .filter { section -> section.videos.any { isPurchased || it.isPreview } }
            .forEach { section ->
                val isExpanded = expandedMap[section.id] == true
                val sectionVisibleVideos = section.videos.filter { isPurchased || it.isPreview }
                val sectionVideoCount = sectionVisibleVideos.size
                val sectionTotalSeconds = sectionVisibleVideos.sumOf { it.durationSeconds }
                val sectionFormattedDuration = formatDuration(sectionTotalSeconds)
                Card(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {
                                    expandedMap[section.id] = !isExpanded
                                },
                            ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors =
                        CardDefaults.cardColors(
                            containerColor = if (!isDarkTheme) Color(0xFFF0EFFE) else MaterialTheme.colorScheme.surfaceContainer,
                        ),
                ) {
                    Column {
                        Row(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = section.title,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Medium,
                                    color = if (!isDarkTheme) Color(0xFF2B1BBA) else MaterialTheme.colorScheme.onBackground,
                                )
                                Text(
                                    text = "$sectionVideoCount ${if (sectionVideoCount == 1) {
                                        "video"
                                    } else {
                                        "videos"
                                    }} · $sectionFormattedDuration",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Gray,
                                )
                            }
                            Box(
                                modifier =
                                    Modifier
                                        .size(28.dp)
                                        .background(
                                            if (!isDarkTheme) Color(0xFFD5D1F3) else MaterialTheme.colorScheme.secondaryContainer,
                                            shape = CircleShape,
                                        ),
                                contentAlignment = Alignment.Center,
                            ) {
                                Icon(
                                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                    contentDescription = null,
                                    tint = if (!isDarkTheme) Color(0xFF2B1BBA) else MaterialTheme.colorScheme.onSecondaryContainer,
                                )
                            }
                        }

                        AnimatedVisibility(visible = isExpanded) {
                            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                                section.videos
                                    .filter { isPurchased || it.isPreview }
                                    .sortedBy { it.order }
                                    .forEach { video ->
                                        val isWatched = watchedVideoIds.contains(video.id)
                                        Card(
                                            modifier =
                                                Modifier
                                                    .fillMaxWidth()
                                                    .padding(vertical = 4.dp)
                                                    .clickable(
                                                        enabled = isPurchased,
                                                        onClick = { onClick(course.id, video.id) },
                                                    ),
                                            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                            colors =
                                                CardDefaults.cardColors(
                                                    containerColor =
                                                        if (isWatched) {
                                                            Color(0xFF2B1BBA)
                                                        } else {
                                                            MaterialTheme.colorScheme.surface
                                                        },
                                                ),
                                        ) {
                                            Row(
                                                modifier = Modifier.padding(start = 16.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                            ) {
//                                                AsyncImage(
//                                                    model = course.thumbnailUrl,
//                                                    contentDescription = course.title,
//                                                    modifier =
//                                                        Modifier
//                                                            .width(80.dp)
//                                                            .height(80.dp),
//                                                    // .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)),
//                                                    contentScale = ContentScale.Crop,
//                                                )
                                                val playIconColor =
                                                    if (isDarkTheme) {
                                                        Color.White
                                                    } else if (isWatched) {
                                                        Color.White
                                                    } else {
                                                        Color.Blue
                                                    }

                                                Icon(
                                                    imageVector = Icons.Filled.PlayCircle, // o Icons.Outlined.PlayCircle
                                                    contentDescription = "Video",
                                                    modifier =
                                                        Modifier
                                                            .size(36.dp),
                                                    tint = playIconColor,
                                                )
                                                Column(modifier = Modifier.padding(12.dp)) {
                                                    Text(
                                                        video.title,
                                                        style = MaterialTheme.typography.titleSmall,
                                                        fontWeight = FontWeight.Bold,
                                                        modifier = Modifier.padding(vertical = 4.dp),
                                                        maxLines = 2,
                                                        color = if (isWatched) Color.White else MaterialTheme.colorScheme.onSurface,
                                                    )
                                                    Row(
                                                        modifier = Modifier.fillMaxWidth(),
                                                        horizontalArrangement = Arrangement.SpaceBetween,
                                                        verticalAlignment = Alignment.CenterVertically,
                                                    ) {
                                                        Text(
                                                            "Duración: ${formatDuration(video.durationSeconds)}",
                                                            style = MaterialTheme.typography.bodySmall,
                                                            color = if (isWatched) Color.White else MaterialTheme.colorScheme.onSurface,
                                                        )

                                                        if (isPurchased && isWatched) {
                                                            Text(
                                                                "✅ Visto",
                                                                color = Color.Green,
                                                                style = MaterialTheme.typography.bodySmall,
                                                            )
                                                        }

//                                                        if (!isPurchased && video.isPreview) {
//                                                            Text(
//                                                                "🎬 Vista previa",
//                                                                color = Color.Blue,
//                                                                style = MaterialTheme.typography.bodySmall,
//                                                            )
//                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                            }
                        }
                    }
                }
            }
    }
}
