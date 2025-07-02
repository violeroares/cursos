package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.rockandcode.cursos.R
import com.rockandcode.cursos.ui.components.CategoryChip
import com.rockandcode.cursos.ui.components.HomeCategoryCard
import com.rockandcode.cursos.ui.components.HomeCourseCard
import com.rockandcode.cursos.ui.components.IncompleteCourseCard

@Composable
fun HomeScreen(
    modifier: Modifier,
    controller: NavHostController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    val isDarkTheme = isSystemInDarkTheme()
    when (val uiState = state) {
        is HomeUiState.Loading -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
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

            val incompleteCourses =
                user.progressByCourse.mapNotNull { progress ->
                    val course = user.purchasedCourses.find { it.id == progress.courseId }
                    if (course != null) {
                        val percent = progress.percentCompleted(course)
                        if (percent < 100.0) {
                            course to percent
                        } else {
                            null
                        }
                    } else {
                        null
                    }
                }

            val randomIncomplete = incompleteCourses.randomOrNull()
            val headerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
            // Color(0xFF2B1BBA)

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                contentWindowInsets = WindowInsets(0),
            ) { paddingValues ->
                LazyColumn(
                    modifier =
                        Modifier
                            .fillMaxSize(),
                    // .padding(horizontal = 16.dp),
                    contentPadding = paddingValues,
                ) {
                    // Top bar: avatar + notificación
                    item {
                        Column(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .background(
                                        color = headerColor,
                                        shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                                    ).padding(top = 24.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            // Línea 1: avatar, "Acadexa", notificaciones
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                AsyncImage(
                                    model = user.avatarUrl,
                                    contentDescription = "Avatar",
                                    modifier = Modifier.size(40.dp).clip(CircleShape),
                                    contentScale = ContentScale.Crop,
                                )
                                Image(
                                    painterResource(
                                        id = if (isDarkTheme) R.drawable.logo_acadexa_dark else R.drawable.logo_acadexa_black,
                                    ),
                                    contentDescription = "logo",
                                    Modifier.height(28.dp),
                                )
                                IconButton(onClick = { /* abrir notificaciones */ }) {
                                    Icon(Icons.Default.Notifications, contentDescription = "Notificaciones")
                                }
                            }

                            // Línea 2: barra de búsqueda simulada
                            Spacer(modifier = Modifier.height(12.dp))
                            Box(
                                modifier =
                                    Modifier
                                        .fillMaxWidth()
                                        .height(48.dp)
                                        .clip(RoundedCornerShape(24.dp))
                                        .background(MaterialTheme.colorScheme.surface)
                                        .clickable {
                                            // Navegá a la pantalla de búsqueda real
                                            controller.navigate("search")
                                        }.padding(horizontal = 16.dp),
                                contentAlignment = Alignment.CenterStart,
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        Icons.Default.Search,
                                        contentDescription = "Buscar",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "Buscar cursos...",
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        style = MaterialTheme.typography.bodyMedium,
                                    )
                                }
                            }
                        }
                    }
                    // Curso incompleto
                    randomIncomplete?.let { (course, percent) ->
                        item {
                            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                                Spacer(modifier = Modifier.height(24.dp))
                                Text(
                                    "¡Seguí aprendiendo!",
                                    style = MaterialTheme.typography.titleMedium,
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                IncompleteCourseCard(
                                    course = course,
                                    percent = percent,
                                    onClick = {
                                        controller.navigate("courseDetail/${course.id}")
                                    },
                                )
                            }
                        }
                    }
                    // Categorías preferidas del usuario
                    if (user.preferredCategories.isNotEmpty()) {
                        item {
                            Column {
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    "Categorías recomendadas",
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier.padding(horizontal = 16.dp),
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                LazyRow(
                                    contentPadding = PaddingValues(horizontal = 16.dp),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    items(user.preferredCategories) { category ->
                                        HomeCategoryCard(
                                            category,
                                            onClick = { controller.navigate(("search?categoryId=${category.id}")) },
                                        )
                                    }
                                }
                            }
                        }
                    }
                    // Cursos populares
                    item {
                        Column {
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                "Cursos populares",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(horizontal = 16.dp),
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                items(bought) { course ->
                                    HomeCourseCard(
                                        course = course,
                                        onClick = {
                                            controller.navigate("courseDetail/${course.id}")
                                        },
                                        // isPurchased = uiState.purchasedCourseIds.contains(course.id),
                                    )
                                }
                            }
                        }
                    }
                    // Categorías
                    item {
                        Column {
                            Spacer(modifier = Modifier.height(24.dp))
                            Text(
                                "Categorías",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(horizontal = 16.dp),
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                items(categories) { category ->
                                    CategoryChip(
                                        category,
                                        onClick = { controller.navigate(("search?categoryId=${category.id}")) },
                                    )
                                }
                            }
                        }
                    }
                    // Cursos mejor valorados
                    item {
                        Column {
                            Spacer(modifier = Modifier.height(24.dp))
                            Text(
                                "Los más valorados",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(horizontal = 16.dp),
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                items(rated) { course ->
                                    HomeCourseCard(
                                        course = course,
                                        onClick = {
                                            controller.navigate("courseDetail/${course.id}")
                                        },
                                        // isPurchased = uiState.purchasedCourseIds.contains(course.id),
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(120.dp))
                        }
                    }
                }
            }
        }
    }
}
