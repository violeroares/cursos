package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.rockandcode.cursos.ui.components.AppHeader

@Composable
fun InstructorScreen(
    instructorId: Int,
    viewModel: InstructorViewModel = hiltViewModel(),
    controller: NavHostController,
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(instructorId) {
        viewModel.loadInstructor(instructorId)
    }

    when (uiState) {
        is InstructorUiState.Loading -> {
            CircularProgressIndicator()
        }
        is InstructorUiState.Success -> {
            val instructor = (uiState as InstructorUiState.Success).instructor

            Scaffold(
                topBar = {
                    AppHeader(
                        title = instructor.name,
                        onBack = { controller.popBackStack() },
                    )
                },
                contentWindowInsets = WindowInsets(0),
            ) { innerPadding ->
                LazyColumn(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(horizontal = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    item {
                        Spacer(modifier = Modifier.height(32.dp))

                        AsyncImage(
                            model = instructor.avatarUrl,
                            contentDescription = "Avatar",
                            modifier =
                                Modifier
                                    .size(120.dp)
                                    .clip(CircleShape)
                                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
                        )

                        Spacer(Modifier.height(16.dp))

                        Text(
                            text = instructor.name,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )

                        instructor.specialization?.let {
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = it,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center,
                            )
                        }

                        Spacer(Modifier.height(24.dp))
                    }

                    // Bio
                    instructor.bio?.let {
                        item {
                            SectionCard(
                                title = "Sobre mí",
                                content = it,
                                icon = Icons.Default.Person,
                            )
                            Spacer(Modifier.height(16.dp))
                        }
                    }

                    // Experiencia
                    instructor.experience?.let {
                        item {
                            SectionCard(
                                title = "Experiencia",
                                content = it,
                                icon = Icons.Default.Star,
                            )
                            Spacer(Modifier.height(16.dp))
                        }
                    }
                }
            }
        }

        is InstructorUiState.Error -> {
            val message = (uiState as InstructorUiState.Error).message
            Text(text = "Error: $message", color = Color.Red)
        }
    }
}

@Composable
fun SectionCard(
    title: String,
    content: String,
    icon: ImageVector,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 20.sp,
            )
        }
    }
}
