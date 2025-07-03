package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.rockandcode.cursos.ui.components.CourseCertificateCard
import com.rockandcode.cursos.ui.components.CourseDescription
import com.rockandcode.cursos.ui.components.CourseDocuments
import com.rockandcode.cursos.ui.components.CourseIncludes
import com.rockandcode.cursos.ui.components.CoursePurchaseButton
import com.rockandcode.cursos.ui.components.CourseRequirements
import com.rockandcode.cursos.ui.components.CourseTags
import com.rockandcode.cursos.ui.components.CourseTopics
import com.rockandcode.cursos.ui.components.CourseVideos

@Composable
fun CourseDetailScreen(
    courseId: Int,
    viewModel: CourseDetailViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    val state by viewModel.uiState.collectAsState()
    val certificate by viewModel.certificate.collectAsState()

    LaunchedEffect(courseId) {
        viewModel.loadCourse(courseId)
    }

    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Detalle del Curso") },
//                navigationIcon = {
//                    IconButton(onClick = onBack) {
//                        Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Atrás")
//                    }
//                },
//            )
//        },
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

                Column(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .verticalScroll(rememberScrollState()),
                ) {
                    // CourseImg + Back
                    Box(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .height(240.dp),
                    ) {
                        AsyncImage(
                            model = course.thumbnailUrl,
                            contentDescription = course.title,
                            modifier =
                                Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)),
                            contentScale = ContentScale.Crop,
                        )

                        IconButton(
                            onClick = onBack,
                            modifier =
                                Modifier
                                    .align(Alignment.TopStart)
                                    .padding(top = 32.dp, start = 16.dp)
                                    .background(
                                        color = Color.Black.copy(alpha = 0.4f),
                                        shape = CircleShape,
                                    ).size(36.dp),
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Atrás",
                                tint = Color.White,
                            )
                        }
                    }

                    // Title
                    Text(
                        course.title,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                    )
                    // SubTitle
                    Text(
                        course.subTitle,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp),
                    )

                    // Author
                    course.author?.let { author ->
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text("Creado por ", style = MaterialTheme.typography.bodyMedium)
                            Text(author.name, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                        }
                    }

                    // Stars
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 16.dp),
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
                                modifier = Modifier.size(20.dp),
                            )
                        }
                        Text(
                            "${"%.1f".format(course.rating)} (${course.ratingCount} valoraciones)",
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }

                    Text(
                        "${course.totalStudents} estudiantes",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                        modifier = Modifier.padding(horizontal = 16.dp),
                    )

                    // Last Update
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text("Ultima actualización:", style = MaterialTheme.typography.bodySmall)
                        Text(course.updatedAt, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
                    }

                    // Course level:
                    Text(
                        text = "Nivel: ${course.level.name}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp),
                    )

                    // Boton comprar
                    if (!uiState.isPurchased) {
                        CoursePurchaseButton(course)
                    }

                    // Topics
                    if (!uiState.isPurchased && course.topics.isNotEmpty()) {
                        CourseTopics(course = course)
                    }

                    // Progreso y certitifado de curso completado
                    if (uiState.isPurchased) {
                        CourseCertificateCard(progress = progress, certificateUrl = certificate?.certificateUrl)
                    }

                    // Videos
                    CourseVideos(
                        course = course,
                        userProgress = uiState.userProgress,
                        onClick = { courseId, videoId ->
                            viewModel.toggleWatched(
                                courseId,
                                videoId,
                            )
                        },
                        isPurchased = uiState.isPurchased,
                    )

                    // Materiales del curso
                    if (uiState.isPurchased && course.documents.isNotEmpty()) {
                        CourseDocuments(course)
                    }

                    // Instructor
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
                        colors =
                            CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surface,
                            ),
                    ) {
                        Text("Instructor", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(8.dp))
                        course.instructors.forEach { instructor ->
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
                                    Text(
                                        instructor.name,
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = FontWeight.Bold,
                                    )
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

                    // Includes + Requeriments
                    if (!uiState.isPurchased) {
                        CourseIncludes(course)
                        CourseRequirements(course)
                    }

                    // Descripcion
                    CourseDescription(course.description)

                    // Tags
                    if (course.tags.isNotEmpty()) {
                        CourseTags(course, onClick = {})
                    }

                    Spacer(Modifier.height(48.dp))
                }
            }
        }
    }
}
