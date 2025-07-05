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
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.SignalCellularAlt
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 4.dp),
                    )
                    // SubTitle
                    Text(
                        course.subTitle,
                        style = MaterialTheme.typography.titleMedium.copy(lineHeight = 22.sp),
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                    )

                    // Author
                    course.author?.let { author ->
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text("Creado por: ", style = MaterialTheme.typography.titleMedium, color = Color.Gray)
                            Text(author.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        }
                    }

                    // Stars
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                    ) {
                        // ⭐ Parte izquierda: número + estrellas
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f),
                        ) {
                            Text(
                                text = "%.1f".format(course.rating),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(end = 8.dp, bottom = 4.dp),
                                color = Color(0xFFF7C33F),
                            )

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
                                    modifier = Modifier.size(20.dp),
                                )
                            }
                        }

                        // 📝 Parte derecha: valoraciones
                        Text(
                            text = "${course.ratingCount} valoraciones",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Gray,
                            textAlign = TextAlign.End,
                        )
                    }

                    // Total students
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.People,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.padding(end = 8.dp),
                        )
                        Text(
                            text = "${course.totalStudents} estudiantes",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium,
                        )
                    }

                    // Last Update
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Refresh,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.padding(end = 8.dp),
                        )
                        Text(
                            text = "Ultima actualización: ${course.updatedAt}",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                        )
                    }

                    // Course level:
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.SignalCellularAlt,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.padding(end = 8.dp),
                        )
                        Text(
                            text = "Nivel: ${course.level.name}",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                        )
                    }

                    // Boton comprar
                    if (!uiState.isPurchased) {
                        CoursePurchaseButton(course)
                    }

                    // Topics
                    if (!uiState.isPurchased && course.topics.isNotEmpty()) {
                        CourseTopics(course = course)
                    }

                    // Includes
                    if (!uiState.isPurchased) {
                        CourseIncludes(course)
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

                    // Requeriments
                    if (!uiState.isPurchased) {
                        CourseRequirements(course)
                    }

                    // Materiales del curso
                    if (uiState.isPurchased && course.documents.isNotEmpty()) {
                        CourseDocuments(course)
                    }

                    // Instructor
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
                        colors =
                            CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.background,
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
