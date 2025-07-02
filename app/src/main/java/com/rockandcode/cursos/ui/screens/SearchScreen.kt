package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.ArrowCircleRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import com.rockandcode.cursos.ui.components.CompactSearchBar
import com.rockandcode.cursos.ui.components.CourseCard

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class,
    ExperimentalLayoutApi::class,
)
@Composable
fun SearchScreen(
    controller: NavHostController,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val filter by viewModel.filter.collectAsState()
    val searchQuery = filter.searchQuery
    val selectedCategories = filter.categories
    val hasFilters = searchQuery.isNotBlank() || selectedCategories.isNotEmpty()

    val filtersActive by viewModel.activeFiltersCount.collectAsState()
    // val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    val allCategories by viewModel.categories.collectAsState(initial = emptyList())
    val filteredCourses by viewModel.filteredCourses.collectAsState(initial = emptyList())
    val courseCountByCategory by viewModel.courseCountByCategory.collectAsState()

    val navBackStackEntry = remember { controller.currentBackStackEntry }
    val categoryIdFromNav = navBackStackEntry?.arguments?.getInt("categoryId")?.takeIf { it != -1 }

    LaunchedEffect(Unit) {
        viewModel.applyInitialCategoryIfNeeded(categoryIdFromNav ?: -1)
    }
    val isDarkTheme = isSystemInDarkTheme()
    Scaffold(
        topBar = {
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),
                            shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                        ).padding(top = 36.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Línea 1: avatar, "Acadexa", notificaciones
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(onClick = { controller.popBackStack() }) {
                        Box(
                            modifier =
                                Modifier
                                    .size(36.dp)
                                    .background(MaterialTheme.colorScheme.secondaryContainer, shape = CircleShape),
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Volver",
                                tint = MaterialTheme.colorScheme.onSecondaryContainer,
                            )
                        }
                    }
                    Text(
                        "Buscar en",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                    )
                    Image(
                        painterResource(
                            id = if (isDarkTheme) R.drawable.logo_acadexa_dark else R.drawable.logo_acadexa_black,
                        ),
                        contentDescription = "logo",
                        Modifier.height(28.dp),
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                // Línea 2: barra de búsqueda
                CompactSearchBar(
                    searchQuery = searchQuery,
                    filtersActive = filtersActive,
                    onQueryChange = { viewModel.setSearchQuery(it) },
                    onFilterClick = { controller.navigate("search/filters") },
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
        },
        contentWindowInsets = WindowInsets(0),
    ) { paddingValues ->
        LazyColumn(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
            // verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = paddingValues,
        ) {
            // Si no hay filtros activos: mostrar chips + categorías
            if (!hasFilters) {
//                item {
//                    LazyRow(
//                        modifier =
//                            Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 8.dp),
//                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                    ) {
//                        items(allCategories) { category ->
//                            FilterChip(
//                                selected = selectedCategories.contains(category.id),
//                                onClick = { viewModel.onCategoryToggled(category.id) },
//                                label = { Text(category.name) },
//                            )
//                        }
//                    }
//                }
                // Chips de categorías
                item {
                    Spacer(modifier = Modifier.height(12.dp))
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        allCategories.forEach { category ->
                            FilterChip(
                                selected = selectedCategories.contains(category.id),
                                onClick = { viewModel.onCategoryToggled(category.id) },
                                label = { Text(category.name) },
                            )
                        }
                    }
                }
                items(allCategories) { category ->
                    val count = courseCountByCategory[category.id] ?: 0
                    ListItem(
                        leadingContent = {
                            AsyncImage(
                                model = category.imageUrl,
                                contentDescription = "Imagen de ${category.name}",
                                modifier =
                                    Modifier
                                        .size(48.dp)
                                        .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop,
                            )
                        },
                        headlineContent = { Text(category.name) },
                        supportingContent = { Text("$count curso${if (count != 1) "s" else ""}") },
                        trailingContent = {
                            Icon(
                                imageVector = Icons.Outlined.ArrowCircleRight,
                                contentDescription = "Ver cursos de la categoría",
                            )
                        },
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .clickable {
                                    viewModel.onCategoryToggled(category.id)
                                },
                    )
                }
            } else {
                item {
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Column {
                            when (selectedCategories.size) {
                                0 -> {
                                    // No mostrar nada si no hay categorías
                                }
                                1 -> {
                                    val categoryName = allCategories.find { it.id in selectedCategories }?.name
                                    categoryName?.let {
                                        Text(text = it, style = MaterialTheme.typography.labelLarge)
                                    }
                                }
                                else -> {
                                    Text(
                                        text = "${selectedCategories.size} categorías seleccionadas",
                                        style = MaterialTheme.typography.labelLarge,
                                    )
                                }
                            }

                            Text(
                                text = "${filteredCourses.size} curso${if (filteredCourses.size != 1) "s" else ""}",
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }

                        TextButton(onClick = { viewModel.resetFilters() }) {
                            Icon(Icons.Default.Clear, contentDescription = null)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Borrar filtros")
                        }
                    }
                }
                // Si hay filtros activos: mostrar cursos
                if (filteredCourses.isEmpty()) {
                    item {
                        Box(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 24.dp),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text("No se encontraron cursos")
                        }
                    }
                } else {
                    items(filteredCourses) { course ->
                        CourseCard(
                            course = course,
                            onClick = {
                                controller.navigate("courseDetail/${course.id}")
                            },
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}
