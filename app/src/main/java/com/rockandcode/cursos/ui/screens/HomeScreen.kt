package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.rockandcode.cursos.ui.components.CategoryChip
import com.rockandcode.cursos.ui.components.HomeCourseCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    controller: NavHostController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()

    when (val uiState = state) {
        is HomeUiState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is HomeUiState.Error -> {
            Text("Error: ${uiState.message}")
        }

        is HomeUiState.Success -> {
            val user = uiState.user
            val bought = uiState.mostBoughtCourses
            val rated = uiState.bestRatedCourses
            val categories = uiState.categories
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                contentWindowInsets = WindowInsets(0),
            ) { paddingValues ->
                LazyColumn(
                    modifier =
                        modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                    contentPadding = paddingValues,
                ) {
                    // Top bar: avatar + notificación
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            AsyncImage(
                                model = user.avatarUrl,
                                contentDescription = "Avatar",
                                modifier = Modifier.size(48.dp).clip(CircleShape),
                            )
                            IconButton(onClick = { /* abrir notificaciones */ }) {
                                Icon(
                                    Icons.Default.Notifications,
                                    contentDescription = "Notificaciones",
                                )
                            }
                        }
                    }
                    // Cursos populares
                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                        Text("Populares", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        LazyRow {
                            items(bought) { course ->
                                HomeCourseCard(course = course, onClick = {
                                    controller.navigate("courseDetail/${course.id}")
                                })
                            }
                        }
                    }
                    // Categorías
                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                        Text("Categorías", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        LazyRow {
                            items(categories) { category ->
                                CategoryChip(category)
                            }
                        }
                    }
                    // Cursos mejor valorados
                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                        Text("Mejor valorados", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        LazyRow {
                            items(rated) { course ->
                                HomeCourseCard(
                                    course = course,
                                    onClick = {
                                        controller.navigate("courseDetail/${course.id}")
                                    },
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(32.dp))
                    }
                }
            }
        }
    }
}
