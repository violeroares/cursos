package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.rockandcode.cursos.ui.components.AppHeader
import com.rockandcode.cursos.ui.components.HomeSectionTitle
import com.rockandcode.cursos.ui.components.MedalView
import com.rockandcode.cursos.utils.getMedalProgress

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    controller: NavHostController,
    onLogout: () -> Unit,
) {
    val state by viewModel.uiState.collectAsState()
    val isDarkTheme = isSystemInDarkTheme()

    when (val uiState = state) {
        is ProfileUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is ProfileUiState.Error -> {
            Text("Error: ${uiState.message}")
        }

        is ProfileUiState.Success -> {
            val user = uiState.user
            val allMedals = uiState.allMedals
            Scaffold(
                topBar = {
                    // CustomHeader(title = "Mi progreso", onBack = { controller.popBackStack() })
                    AppHeader(
                        title = "Mi perfil",
                        onBack = { controller.popBackStack() },
                        actions = {
                            IconButton(onClick = onLogout) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                    contentDescription = "Cerrar sesión",
                                    tint = Color.White,
                                )
                            }
                        },
                    )
                },
                contentWindowInsets = WindowInsets(0),
            ) { paddingValues ->
                LazyColumn(
                    modifier =
                        Modifier
                            .fillMaxSize(),
                    contentPadding = paddingValues,
                ) {
                    // Avatar + nombre
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            AsyncImage(
                                model = user.avatarUrl,
                                contentDescription = null,
                                modifier =
                                    Modifier
                                        .size(120.dp)
                                        .clip(CircleShape),
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(
                                text = user.name,
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = "Puntaje: ${user.score}",
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                    val (prev, current, next) = getMedalProgress(user.score, allMedals)
                    item {
                        Spacer(Modifier.height(16.dp))
                        HomeSectionTitle(title = "Mis logros", showButton = true, onClick = {})
                        Spacer(Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
//                            MedalView(medal = prev, label = "Nivel Anterior")
                            MedalView(medal = current, label = "Nivel Actual")
//                            MedalView(medal = next, label = "Nivel Siguiente")
                        }
                        Spacer(Modifier.height(20.dp))
                    }

                    item {
                        // Cursos comprados: LazyColumn continua
                        HomeSectionTitle(title = "Mis cursos", showButton = false, onClick = {})
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    items(user.purchasedCourses) { course ->
                        val progress =
                            user.progressByCourse
                                .find { it.courseId == course.id }
                                ?.percentCompleted(course) ?: 0.0
                        Card(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                                    .clickable { controller.navigate("courseDetail/${course.id}") },
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
                                            text = "%.1f%%".format(progress),
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Bold,
                                        )
                                    }
                                    LinearProgressIndicator(
                                        progress = { (progress / 100f).toFloat() },
                                        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}
