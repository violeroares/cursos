package com.rockandcode.cursos.ui.screens

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.rockandcode.cursos.R
import com.rockandcode.cursos.ui.components.CourseIncludes
import com.rockandcode.cursos.ui.components.CourseRequirements

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CourseDetailScreen(
    courseId: Int,
    viewModel: CourseDetailViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    val state by viewModel.uiState.collectAsState()
    val certificate by viewModel.certificate.collectAsState()
    val context = LocalContext.current

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
                val videosToShow =
                    if (uiState.isPurchased) {
                        course.items
                    } else {
                        course.items.filter { it.isPreview }
                    }.sortedBy { it.order }

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
                    // Mostrar nivel del curso:
                    Text(
                        text = "Nivel: ${course.level.name}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(vertical = 4.dp),
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(course.subTitle, style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(4.dp))
                    // Rating + cantidad de valoraciones + estudiantes
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp),
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
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "${"%.1f".format(course.rating)} (${course.ratingCount} valoraciones)",
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                    Text("${course.totalStudents} estudiantes", style = MaterialTheme.typography.bodySmall, color = Color.Gray)

                    // Autor
                    course.author?.let { author ->
                        Spacer(Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Creado por ", style = MaterialTheme.typography.bodyMedium)
                            Text(author.name, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                        }
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Ultima actualización:", style = MaterialTheme.typography.bodyMedium)
                        Text(course.updatedAt, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                    }

                    // Progreso y certitifado de curso completado
                    if (uiState.isPurchased) {
                        Spacer(Modifier.height(16.dp))
                        Text("Progreso: %.1f%%".format(progress))
                        LinearProgressIndicator(
                            progress = { (progress / 100f).toFloat() },
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                        )

                        if (progress >= 100.0) {
                            Spacer(Modifier.height(16.dp))
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                colors =
                                    CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                    ),
                            ) {
                                Row(
                                    modifier = Modifier.padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.EmojiEvents,
                                        contentDescription = "Certificado",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(40.dp),
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column {
                                        Text("¡Felicitaciones!", style = MaterialTheme.typography.titleMedium)
                                        Text("Completaste el curso y obtuviste un certificado 🎓")

                                        Button(onClick = {
                                            val intent =
                                                Intent(
                                                    Intent.ACTION_VIEW,
                                                    certificate?.certificateUrl?.toUri(),
                                                )
                                            context.startActivity(intent)
                                        }) {
                                            Icon(Icons.Default.Description, contentDescription = null)
                                            Spacer(Modifier.width(8.dp))
                                            Text("Ver certificado")
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // Boton comprar
                    if (!uiState.isPurchased) {
                        Spacer(Modifier.height(24.dp))
                        Text(
                            text = if (!course.isFree) "\$${course.price}" else "Gratuito",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(Modifier.height(8.dp))
                        Button(
                            onClick = { /* Comprar */ },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(if (!course.isFree) "Comprar ahora" else "Inscribirse ahora")
                        }
                        Spacer(Modifier.height(24.dp))
                    }

                    // Topics
                    if (!uiState.isPurchased && course.topics.isNotEmpty()) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                            shape = RoundedCornerShape(8.dp),
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("Lo que aprenderás", style = MaterialTheme.typography.titleMedium)
                                Spacer(Modifier.height(8.dp))
                                course.topics.forEach { topic ->
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(vertical = 4.dp),
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.primary,
                                            modifier = Modifier.size(20.dp),
                                        )
                                        Spacer(Modifier.width(8.dp))
                                        Text(topic, style = MaterialTheme.typography.bodyMedium)
                                    }
                                }
                            }
                        }
                        Spacer(Modifier.height(24.dp))
                    }

                    // Videos
                    Spacer(Modifier.height(16.dp))
                    Text("Videos", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(8.dp))
                    videosToShow.forEach { video ->
                        val isWatched = watchedVideoIds.contains(video.id)

                        Card(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                                    .clickable(
                                        enabled = uiState.isPurchased,
                                        onClick = {
                                            viewModel.toggleWatched(
                                                course.id,
                                                video.id,
                                            )
                                        },
                                    ),
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
                                    Text(
                                        "Duración: ${video.durationSeconds} seg",
                                        style = MaterialTheme.typography.bodySmall,
                                    )

                                    if (uiState.isPurchased && isWatched) {
                                        Text(
                                            "✅  Visto",
                                            color = Color.Green,
                                            style = MaterialTheme.typography.bodySmall,
                                            modifier = Modifier.padding(vertical = 8.dp),
                                        )
                                    }

                                    if (!uiState.isPurchased && video.isPreview) {
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

                    // Materiales del curso
                    if (uiState.isPurchased && course.documents.isNotEmpty()) {
                        Spacer(Modifier.height(24.dp))
                        Text("Materiales del curso", style = MaterialTheme.typography.titleMedium)
                        course.documents.forEach { doc ->
                            val iconRes =
                                when (doc.documentType.fileExtension?.lowercase()) {
                                    "pdf" -> R.drawable.ic_pdf
                                    "doc", "docx" -> R.drawable.ic_pdf
                                    "xls", "xlsx" -> R.drawable.ic_pdf
                                    "ppt", "pptx" -> R.drawable.ic_pdf
                                    else -> R.drawable.ic_pdf
                                }
                            Row(
                                modifier =
                                    Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            val intent = Intent(Intent.ACTION_VIEW, doc.url.toUri())
                                            context.startActivity(intent)
                                        }.padding(vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                // Icon(Icons.Default.Description, contentDescription = null)
                                Icon(painterResource(iconRes), contentDescription = doc.documentType.name)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(doc.title, style = MaterialTheme.typography.bodyLarge)
                                    // Text(doc.description, style = MaterialTheme.typography.bodySmall)
                                }
                                Icon(
                                    imageVector = Icons.Default.Download, // o Icons.Outlined.Download
                                    contentDescription = "Descargar",
                                    tint = MaterialTheme.colorScheme.primary,
                                )
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                    }

                    // Instructores
                    Text("Instructores", style = MaterialTheme.typography.titleMedium)
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
                                        .size(40.dp)
                                        .clip(CircleShape),
                            )
                            Spacer(Modifier.width(8.dp))
                            Column {
                                Text(instructor.name, style = MaterialTheme.typography.bodyLarge)
                                if (!instructor.bio.isNullOrEmpty()) {
                                    Text(instructor.bio, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                                } else {
                                    Text("Instructor experto", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                                }
                                instructor.specialization?.let {
                                    Text(it, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                                }
                            }
                        }
                    }

                    // Includes + Requeriments
                    if (!uiState.isPurchased) {
                        Spacer(Modifier.height(16.dp))
                        Text("Este curso incluye:", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(8.dp))
                        CourseIncludes(course.includes)
                        Spacer(Modifier.height(24.dp))
                        Text("Requisitos:", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(8.dp))
                        CourseRequirements(course.requirements)
                        Spacer(Modifier.height(24.dp))
                    }

                    // Descripcion
                    Text("Descripción", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(8.dp))
                    Text(course.description, style = MaterialTheme.typography.bodyMedium)

                    // Tags
                    if (course.tags.isNotEmpty()) {
                        Spacer(Modifier.height(32.dp))
                        Text("Temas relacionados", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(8.dp))
                        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            course.tags.forEach { tag ->
                                FilterChip(
                                    selected = false,
                                    onClick = { /* navegar a búsqueda por tag o lo que sea */ },
                                    label = { Text(tag) },
                                )
                            }
                        }
                    }

                    Spacer(Modifier.height(48.dp))
                }
            }
        }
    }
}
