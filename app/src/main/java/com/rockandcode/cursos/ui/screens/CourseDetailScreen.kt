package com.rockandcode.cursos.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetailScreen(
    courseId: Int,
    viewModel: CourseDetailViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(courseId) {
        viewModel.loadCourse(courseId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del Curso") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Atrás")
                    }
                },
            )
        },
        contentWindowInsets = WindowInsets(0),
    ) { paddingValues ->
        when (val uiState = state.uiState) {
            is CourseDetailUiState.Loading -> {
                Box(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            }

            is CourseDetailUiState.Error -> {
                Box(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(text = uiState.message, color = MaterialTheme.colorScheme.error)
                }
            }

            is CourseDetailUiState.Success -> {
                val course = uiState.course
                val progress = uiState.userProgress?.percentCompleted(course) ?: 0.0
                val watchedVideoIds = uiState.userProgress?.videoProgress?.map { it.videoId } ?: emptyList()

                Column(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .verticalScroll(rememberScrollState())
                            .padding(horizontal = 16.dp),
                ) {
                    AsyncImage(
                        model = course.thumbnailUrl,
                        contentDescription = course.title,
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(course.title, style = MaterialTheme.typography.headlineSmall)
                    Spacer(Modifier.height(8.dp))
                    Text(course.description, style = MaterialTheme.typography.bodyMedium)

                    Spacer(Modifier.height(16.dp))

                    if (uiState.isPurchased) {
                        Text("Progreso: %.1f%%".format(progress))
                        LinearProgressIndicator(
                            progress = { (progress / 100f).toFloat() },
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                        )

                        Spacer(Modifier.height(16.dp))
                        Text("Videos", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(8.dp))

                        course.items.forEach { video ->
                            val isWatched = watchedVideoIds.contains(video.id)
                            Log.d("CourseDetailScreen", "Video ${video.id} isWatched=$isWatched")
                            Card(
                                modifier =
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp)
                                        .clickable {
                                            viewModel.toggleWatched(course.id, video.id)
                                        },
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
                                                .width(100.dp)
                                                .height(100.dp)
                                                .clip(RoundedCornerShape(8.dp)),
                                        contentScale = ContentScale.Crop,
                                    )
                                    Column(modifier = Modifier.padding(12.dp)) {
                                        Text(
                                            video.title,
                                            style = MaterialTheme.typography.bodyLarge,
                                            modifier = Modifier.padding(vertical = 4.dp),
                                        )
                                        Text("Duración: ${video.durationSeconds} seg", style = MaterialTheme.typography.bodySmall)
                                        if (isWatched) {
                                            Text(
                                                "✅  Visto",
                                                color = Color.Green,
                                                style = MaterialTheme.typography.bodySmall,
                                                modifier = Modifier.padding(vertical = 8.dp),
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        Spacer(Modifier.height(24.dp))
                        Button(
                            onClick = { /* Comprar */ },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text("Comprar Curso - $${course.price}")
                        }
                    }
                }
            }
        }
    }
}
