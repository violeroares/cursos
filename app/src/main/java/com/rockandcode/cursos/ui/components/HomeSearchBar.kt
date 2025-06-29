package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.domain.models.Course

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSearchBar(
    courses: List<Course>,
    onSearchItemSelected: (Course) -> Unit,
    onFilterClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var query by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val searchResults = remember { mutableStateListOf<Course>() }
    val onExpandedChange: (Boolean) -> Unit = {
        expanded = it
    }

    LaunchedEffect(query) {
        searchResults.clear()
        if (query.isNotEmpty()) {
            searchResults.addAll(
                courses.filter {
                    it.title.startsWith(
                        prefix = query,
                        ignoreCase = true,
                    ) ||
                        it.description.startsWith(
                            prefix =
                            query,
                            ignoreCase = true,
                        )
                },
            )
        }
    }

    DockedSearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = query,
                onQueryChange = {
                    query = it
                },
                onSearch = { expanded = false },
                expanded = expanded,
                onExpandedChange = onExpandedChange,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Buscar cursos...") },
                leadingIcon = {
                    if (expanded) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás",
                            modifier =
                                Modifier
                                    .padding(start = 8.dp)
                                    .clickable {
                                        expanded = false
                                        query = ""
                                    },
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar",
                            modifier = Modifier.padding(start = 8.dp),
                        )
                    }
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = "Filtros",
                        modifier = Modifier.padding(end = 8.dp).clickable { onFilterClick() },
                    )
                },
            )
        },
        expanded = expanded,
        onExpandedChange = onExpandedChange,
        modifier = modifier,
        content = {
            if (searchResults.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    items(items = searchResults, key = { it.id }) { course ->
                        ListItem(
                            headlineContent = { Text(course.title) },
                            supportingContent = { Text(course.description) },
                            leadingContent = {
                            },
                            modifier =
                                Modifier.clickable {
                                    onSearchItemSelected.invoke(course)
                                    query = ""
                                    expanded = false
                                },
                        )
                    }
                }
            } else if (query.isNotEmpty()) {
                Text(
                    text = "No se encontraron cursos",
                    modifier = Modifier.padding(16.dp),
                )
            } else {
                Text(
                    text = "No hay historial de búsqueda",
                    modifier = Modifier.padding(16.dp),
                )
            }
        },
    )
}
