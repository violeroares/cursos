package com.rockandcode.cursos.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rockandcode.cursos.domain.models.OrderBy

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FiltersScreen(
    controller: NavHostController,
    searchViewModel: SearchViewModel,
    categoriesViewModel: FiltersViewModel = hiltViewModel(), // ya tenías esto
) {
    val allCategories by categoriesViewModel.categories.collectAsState()
    val currentFilter by searchViewModel.filter.collectAsState()

    val selectedCategories = remember { mutableStateListOf<Int>() }
    val (selectedOrder, setSelectedOrder) = remember { mutableStateOf(currentFilter.orderBy) }
    var minDuration by remember { mutableStateOf(currentFilter.minDuration?.toString() ?: "") }
    var maxDuration by remember { mutableStateOf(currentFilter.maxDuration?.toString() ?: "") }

    // Cargar categorías ya seleccionadas
    LaunchedEffect(currentFilter.categories) {
        selectedCategories.clear()
        selectedCategories.addAll(currentFilter.categories)
        Log.d("FiltersScreen", "Filter: ${currentFilter.categories}")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Filtros") },
                navigationIcon = {
                    IconButton(onClick = { controller.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
            )
        },
    ) { paddingValues ->
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
        ) {
            Text("Categorías", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))

            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                allCategories.forEachIndexed { index, category ->
                    FilterChip(
                        selected = selectedCategories.contains(index),
                        onClick = {
                            if (selectedCategories.contains(index)) {
                                selectedCategories.remove(index)
                            } else {
                                selectedCategories.add(index)
                            }
                        },
                        label = { Text(category.name) },
                    )
                }
            }

            Spacer(Modifier.height(16.dp))
            Text("Ordenar por", style = MaterialTheme.typography.titleMedium)

            OrderBy.entries.forEach { order ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .clickable { setSelectedOrder(order) }
                            .padding(vertical = 4.dp),
                ) {
                    RadioButton(
                        selected = selectedOrder == order,
                        onClick = { setSelectedOrder(order) },
                    )
                    Text(order.name.lowercase().replaceFirstChar { it.uppercase() })
                }
            }

            Spacer(Modifier.height(16.dp))
            Text("Duración (minutos)", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = minDuration,
                    onValueChange = { minDuration = it.filter { ch -> ch.isDigit() } },
                    label = { Text("Mín.") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                )
                OutlinedTextField(
                    value = maxDuration,
                    onValueChange = { maxDuration = it.filter { ch -> ch.isDigit() } },
                    label = { Text("Máx.") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                )
            }

            Spacer(Modifier.height(16.dp))
            TextButton(
                onClick = {
                    searchViewModel.resetFilters()
                    controller.popBackStack()
                },
                modifier = Modifier.align(Alignment.End),
            ) {
                Text("Borrar filtros")
            }

            Spacer(Modifier.height(24.dp))
            Button(
                onClick = {
                    // Aplicar filtros
                    searchViewModel.setCategories(selectedCategories.toSet())
                    searchViewModel.setOrderBy(selectedOrder)
                    searchViewModel.setMinDuration(minDuration.toIntOrNull())
                    searchViewModel.setMaxDuration(maxDuration.toIntOrNull())
                    controller.popBackStack() // volver a SearchScreen
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Aplicar filtros")
            }
        }
    }
}
