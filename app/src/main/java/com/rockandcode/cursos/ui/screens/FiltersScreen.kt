package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.CourseFilter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltersScreen(
    onBack: () -> Unit,
    onApplyFilters: (CourseFilter) -> Unit,
    viewModel: FiltersViewModel = hiltViewModel(),
) {
    val categories by viewModel.categories.collectAsState()

    var selectedCategoryId by remember { mutableStateOf<Int?>(null) }
    var minDuration by remember { mutableStateOf("") }
    var maxDuration by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Filtros") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás")
                    }
                },
                actions = {
                    TextButton(onClick = {
                        onApplyFilters(
                            CourseFilter(
                                categoryId = selectedCategoryId,
                                minDuration = minDuration.toIntOrNull(),
                                maxDuration = maxDuration.toIntOrNull(),
                            ),
                        )
                    }) {
                        Text("Aplicar")
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier =
                Modifier
                    .padding(padding)
                    .padding(16.dp),
        ) {
            Text("Categorías:")
            Spacer(Modifier.height(8.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(categories) { category ->
                    FilterChip(
                        selected = selectedCategoryId == category.id,
                        onClick = { selectedCategoryId = category.id },
                        label = { Text(category.name) },
                        leadingIcon = {
                            AsyncImage(
                                model = category.imageUrl,
                                contentDescription = null,
                                modifier =
                                    Modifier
                                        .size(24.dp)
                                        .clip(CircleShape),
                            )
                        },
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            OutlinedTextField(
                value = minDuration,
                onValueChange = { minDuration = it },
                label = { Text("Duración mínima (segundos)") },
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = maxDuration,
                onValueChange = { maxDuration = it },
                label = { Text("Duración máxima (segundos)") },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
