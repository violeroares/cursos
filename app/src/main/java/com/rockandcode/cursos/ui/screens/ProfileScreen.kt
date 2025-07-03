package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.rockandcode.cursos.ui.components.AppHeader
import com.rockandcode.cursos.ui.components.MedalView
import com.rockandcode.cursos.utils.getMedalProgress

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    controller: NavHostController,
) {
    val state by viewModel.uiState.collectAsState()

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
                        title = "Mi progreso",
                        onBack = { controller.popBackStack() },
                    )
                },
                modifier = Modifier.fillMaxSize(),
                contentWindowInsets = WindowInsets(0),
            ) { paddingValues ->
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    contentPadding = paddingValues,
                ) {
                    // Avatar + nombre
                    item {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            AsyncImage(
                                model = user.avatarUrl,
                                contentDescription = null,
                                modifier = Modifier.size(80.dp).clip(CircleShape),
                            )
                            Spacer(Modifier.width(16.dp))
                            Column {
                                Text(user.name, style = MaterialTheme.typography.titleLarge)
                                Text("Puntaje: ${user.score}")
                            }
                        }
                    }
                    val (prev, current, next) = getMedalProgress(user.score, allMedals)
                    item {
                        Spacer(Modifier.height(16.dp))
                        Row(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 4.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "Tu logros",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                            )
                            TextButton(onClick = { /* navegación a pantalla de medallas */ }) {
                                Text("Ver todas")
                            }
                        }
                        Spacer(Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            MedalView(medal = prev, label = "Anterior")
                            MedalView(medal = current, label = "Actual", highlighted = true, size = 150.dp, iconSize = 60.sp)
                            MedalView(medal = next, label = "Siguiente")
                        }
                        Spacer(Modifier.height(16.dp))
                    }

                    item {
                        // Cursos comprados: LazyColumn continua
                        Row(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "Tus cursos",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                            )
                            TextButton(onClick = { /* navegación a pantalla de cursos comprados */ }) {
                                Text("Ver todos")
                            }
                        }
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
                                    .padding(vertical = 8.dp)
                                    .clickable { controller.navigate("courseDetail/${course.id}") },
                            elevation = CardDefaults.cardElevation(),
                        ) {
                            Column(
                                Modifier
                                    .padding(16.dp),
                            ) {
                                Text(course.title, fontWeight = FontWeight.SemiBold)
                                Text("Progreso: ${"%.1f".format(progress)}%")
                                LinearProgressIndicator(
                                    progress = { (progress / 100f).toFloat() },
                                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
