package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rockandcode.cursos.ui.components.CourseCard

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(
    controller: NavHostController,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val filter by viewModel.filter.collectAsState()
    val searchQuery = filter.searchQuery
    val courses by viewModel.filteredCourses.collectAsState(initial = emptyList())
    val filtersActive by viewModel.activeFiltersCount.collectAsState()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Buscar cursos") },
                navigationIcon = {
                    IconButton(onClick = { controller.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
//                actions = {
//                    IconButton(onClick = { controller.navigate("filters") }) {
//                        BadgedBox(
//                            badge = {
//                                if (filtersActive > 0) {
//                                    Badge { Text(filtersActive.toString()) }
//                                }
//                            },
//                        ) {
//                            Icon(Icons.Default.FilterList, contentDescription = "Filtros")
//                        }
//                    }
//                },
                scrollBehavior = scrollBehavior,
            )
        },
        contentWindowInsets = WindowInsets.statusBars,
    ) { paddingValues ->
        LazyColumn(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = paddingValues,
            // contentPadding = PaddingValues(top = 64.dp, bottom = paddingValues.calculateBottomPadding()),
        ) {
            stickyHeader {
                // Barra de búsqueda
                SearchBar(
                    inputField = {
                        SearchBarDefaults.InputField(
                            query = searchQuery,
                            onQueryChange = { viewModel.setSearchQuery(it) },
                            onSearch = {}, // Podés agregar lógica adicional
                            expanded = false,
                            onExpandedChange = {},
                            placeholder = { Text("Buscar cursos...") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Buscar",
                                    modifier = Modifier.padding(start = 8.dp),
                                )
                            },
                            trailingIcon = {
                                IconButton(onClick = { controller.navigate("filters") }) {
                                    BadgedBox(
                                        badge = {
                                            if (filtersActive > 0) {
                                                Badge { Text(filtersActive.toString()) }
                                            }
                                        },
                                    ) {
                                        Icon(Icons.Default.FilterList, contentDescription = "Filtros")
                                    }
                                }

//                                Icon(
//                                    imageVector = Icons.Default.FilterList,
//                                    contentDescription = "Filtros",
//                                    modifier =
//                                        Modifier
//                                            .padding(end = 8.dp)
//                                            .clickable {
//                                                controller.navigate("filters")
//                                            },
//                                )
                            },
                        )
                    },
                    expanded = false,
                    onExpandedChange = {},
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(0.dp),
                    content = {}, // no desplegable
                )
            }
            if (courses.isEmpty()) {
                item {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("No se encontraron cursos")
                    }
                }
            }
            items(courses) { course ->
                CourseCard(
                    course = course,
                    onClick = {
                        controller.navigate("courseDetail/${course.id}")
                    },
                )
            }
        }
    }
}
