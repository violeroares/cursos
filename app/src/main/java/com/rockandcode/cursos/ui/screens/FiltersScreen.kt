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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.rockandcode.cursos.ui.components.AppHeader

@OptIn(ExperimentalLayoutApi::class)
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
    var minPrice by remember { mutableStateOf(currentFilter.minPrice?.toString() ?: "") }
    var maxPrice by remember { mutableStateOf(currentFilter.maxPrice?.toString() ?: "") }

    // Cargar categorías ya seleccionadas
    LaunchedEffect(currentFilter.categories) {
        selectedCategories.clear()
        selectedCategories.addAll(currentFilter.categories)
        Log.d("FiltersScreen", "Filter: ${currentFilter.categories}")
    }

    Scaffold(
        topBar = {
            AppHeader(
                title = "Filtros",
                onBack = { controller.popBackStack() },
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
                allCategories.forEach { category ->
                    FilterChip(
                        selected = selectedCategories.contains(category.id),
                        onClick = {
                            if (selectedCategories.contains(category.id)) {
                                selectedCategories.remove(category.id)
                            } else {
                                selectedCategories.add(category.id)
                            }
                        },
                        label = { Text(category.name) },
                    )
                }
            }

            Spacer(Modifier.height(16.dp))
            Text("Filtrar por precio", style = MaterialTheme.typography.titleMedium)

            val (showFree, setShowFree) = remember { mutableStateOf(currentFilter.showFree) }
            val (showPaid, setShowPaid) = remember { mutableStateOf(currentFilter.showPaid) }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = showFree, onCheckedChange = { setShowFree(it) })
                Text("Gratis")
                Spacer(Modifier.width(16.dp))
                Checkbox(checked = showPaid, onCheckedChange = { setShowPaid(it) })
                Text("De pago")
            }

//            Spacer(Modifier.height(16.dp))
//            Text("Ordenar por precio", style = MaterialTheme.typography.titleMedium)
//
//            Column {
//                listOf(OrderBy.PRICE_ASC, OrderBy.PRICE_DESC).forEach { order ->
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier =
//                            Modifier
//                                .fillMaxWidth()
//                                .clickable { setSelectedOrder(order) }
//                                .padding(vertical = 4.dp),
//                    ) {
//                        RadioButton(
//                            selected = selectedOrder == order,
//                            onClick = { setSelectedOrder(order) },
//                        )
//                        Text(order.label)
//                    }
//                }
//            }

            Spacer(Modifier.height(16.dp))
            Text("Ordenar por relevancia", style = MaterialTheme.typography.titleMedium)

            Column {
                listOf(OrderBy.TITLE, OrderBy.POPULAR, OrderBy.RATED).forEach { order ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .clickable { setSelectedOrder(order) },
                    ) {
                        RadioButton(
                            selected = selectedOrder == order,
                            onClick = { setSelectedOrder(order) },
                        )
                        Text(order.label)
                    }
                }
            }

//            Spacer(Modifier.height(16.dp))
//            Text("Duración (minutos)", style = MaterialTheme.typography.titleMedium)
//            Spacer(Modifier.height(8.dp))
//            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                OutlinedTextField(
//                    value = minDuration,
//                    onValueChange = { minDuration = it.filter { ch -> ch.isDigit() } },
//                    label = { Text("Mín.") },
//                    modifier = Modifier.weight(1f),
//                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
//                )
//                OutlinedTextField(
//                    value = maxDuration,
//                    onValueChange = { maxDuration = it.filter { ch -> ch.isDigit() } },
//                    label = { Text("Máx.") },
//                    modifier = Modifier.weight(1f),
//                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
//                )
//            }

            Spacer(Modifier.height(12.dp))
            Text("Precio (ARS)", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = minPrice,
                    onValueChange = { minPrice = it.filter { ch -> ch.isDigit() } },
                    label = { Text("Desde") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                )
                OutlinedTextField(
                    value = maxPrice,
                    onValueChange = { maxPrice = it.filter { ch -> ch.isDigit() } },
                    label = { Text("Hasta") },
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
                    searchViewModel.setMinPrice(minPrice.toIntOrNull())
                    searchViewModel.setMaxPrice(maxPrice.toIntOrNull())
                    searchViewModel.setPriceFilter(showFree = showFree, showPaid = showPaid)
                    controller.popBackStack() // volver a SearchScreen
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Aplicar filtros")
            }
        }
    }
}
