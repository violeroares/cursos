package com.rockandcode.cursos.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rockandcode.cursos.domain.models.Category
import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.models.CourseFilter
import com.rockandcode.cursos.domain.models.OrderBy
import com.rockandcode.cursos.domain.repositories.ICourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
    @Inject
    constructor(
        repo: ICourseRepository,
    ) : ViewModel() {
        private val _filter = MutableStateFlow(CourseFilter())
        val filter = _filter.asStateFlow()

//        private val _allCourses = MutableStateFlow<List<Course>>(emptyList())
//
//        init {
//            viewModelScope.launch {
//                repo.getCourses().collect {
//                    _allCourses.value = it
//                }
//            }
//        }
//
//        val filteredCourses: Flow<List<Course>> =
//            combine(_allCourses, _filter) { all, filter ->
//                val filtered =
//                    all.filter { course ->
//                        val totalDurationMinutes = course.items.sumOf { it.durationSeconds } / 60
//
//                        val matchesSearch = filter.searchQuery.isBlank() || course.title.contains(filter.searchQuery, ignoreCase = true)
//                        val matchesCategory = filter.categories.isEmpty() || course.categories.any { it.id in filter.categories }
//                        val matchesMinDuration = filter.minDuration == null || totalDurationMinutes >= filter.minDuration
//                        val matchesMaxDuration = filter.maxDuration == null || totalDurationMinutes <= filter.maxDuration
//
//                        matchesSearch && matchesCategory && matchesMinDuration && matchesMaxDuration
//                    }
//
//                when (filter.orderBy) {
//                    OrderBy.TITLE -> filtered.sortedBy { it.title }
//                    OrderBy.POPULAR -> filtered.sortedByDescending { it.totalStudents }
//                    OrderBy.RATED -> filtered.sortedByDescending { it.rating }
//                    OrderBy.NONE -> filtered
//                }
//            }
// Cursos filtrados combinando flujo de cursos con los filtros activos
        val filteredCourses: StateFlow<List<Course>> =
            combine(repo.getCourses(), filter) { courses, filter ->
                var filtered = courses

                // Filtrar por categorías
                if (filter.categories.isNotEmpty()) {
                    filtered =
                        filtered.filter { course ->
                            course.categories.any { category -> category.id in filter.categories }
                        }
                }

                // Filtrar por duración
                filter.minDuration?.let { min ->
                    filtered = filtered.filter { it.items.sumOf { item -> item.durationSeconds } >= min }
                }
                filter.maxDuration?.let { max ->
                    filtered = filtered.filter { it.items.sumOf { item -> item.durationSeconds } <= max }
                }

                // Filtrar por búsqueda
                if (filter.searchQuery.isNotBlank()) {
                    filtered =
                        filtered.filter {
                            it.title.contains(filter.searchQuery, ignoreCase = true) ||
                                it.description.contains(filter.searchQuery, ignoreCase = true)
                        }
                }

                // Ordenar resultados
                filtered =
                    when (filter.orderBy) {
                        OrderBy.POPULAR -> filtered.sortedByDescending { it.totalStudents }
                        OrderBy.RATED -> filtered.sortedByDescending { it.rating }
                        OrderBy.TITLE -> filtered.sortedBy { it.title }
                        else -> filtered
                    }

                filtered
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

        val categories: StateFlow<List<Category>> =
            repo
                .getCourses()
                .map { courses ->
                    courses
                        .flatMap { it.categories }
                        .distinctBy { it.id }
                        .sortedBy { it.name }
                }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

        fun onCategoryToggled(categoryId: Int) {
            _filter.update { current ->
                val updated =
                    if (categoryId in current.categories) {
                        current.categories - categoryId
                    } else {
                        current.categories + categoryId
                    }
                current.copy(categories = updated)
            }
        }

        val courseCountByCategory: StateFlow<Map<Int, Int>> =
            repo
                .getCourses()
                .map { courses ->
                    courses
                        .flatMap { it.categories.map { cat -> cat.id to 1 } }
                        .groupBy { it.first }
                        .mapValues { it.value.size }
                }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyMap())

        // Métodos para actualizar los filtros
        fun setSearchQuery(query: String) {
            _filter.update { it.copy(searchQuery = query) }
        }

        fun setCategories(selected: Set<Int>) {
            _filter.update { it.copy(categories = selected) }
        }

        fun setOrderBy(order: OrderBy) {
            _filter.update { it.copy(orderBy = order) }
        }

        fun setMinDuration(min: Int?) {
            _filter.update { it.copy(minDuration = min) }
        }

        fun setMaxDuration(max: Int?) {
            _filter.update { it.copy(maxDuration = max) }
        }

        fun resetFilters() {
            _filter.value = CourseFilter()
        }

        // Badge con cantidad de filtros activos
        val activeFiltersCount: StateFlow<Int> =
            filter
                .map { filter ->
                    var count = 0
                    if (filter.categories.isNotEmpty()) count++
                    if (filter.searchQuery.isNotBlank()) count++
                    if (filter.minDuration != null) count++
                    if (filter.maxDuration != null) count++
                    if (filter.orderBy != OrderBy.NONE) count++
                    count
                }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), 0)
    }
