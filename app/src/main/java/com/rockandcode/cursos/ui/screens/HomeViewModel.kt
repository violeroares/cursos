package com.rockandcode.cursos.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rockandcode.cursos.domain.models.Category
import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.models.User
import com.rockandcode.cursos.domain.usecases.GetAllCategoriesUseCase
import com.rockandcode.cursos.domain.usecases.GetBestRatedCoursesUseCase
import com.rockandcode.cursos.domain.usecases.GetCurrentUserUseCase
import com.rockandcode.cursos.domain.usecases.GetMostBoughtCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface HomeUiState {
    object Loading : HomeUiState

    data class Success(
        val user: User,
        val mostBoughtCourses: List<Course>,
        val bestRatedCourses: List<Course>,
        val categories: List<Category>,
    ) : HomeUiState

    data class Error(
        val message: String,
    ) : HomeUiState
}

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getCurrentUserUseCase: GetCurrentUserUseCase,
        private val getMostBoughtCoursesUseCase: GetMostBoughtCoursesUseCase,
        private val getBestRatedCoursesUseCase: GetBestRatedCoursesUseCase,
        private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
        val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

        init {
            loadHomeData()
        }

        private fun loadHomeData() {
            viewModelScope.launch {
                combine(
                    getCurrentUserUseCase(),
                    getMostBoughtCoursesUseCase(),
                    getBestRatedCoursesUseCase(),
                    getAllCategoriesUseCase(),
                ) { user, mostBought, bestRated, categories ->
                    if (user == null) {
                        HomeUiState.Error("Usuario no disponible")
                    } else {
                        HomeUiState.Success(user, mostBought, bestRated, categories)
                    }
                }.catch {
                    _uiState.value = HomeUiState.Error("Error al cargar el Home")
                }.collect {
                    _uiState.value = it
                }
            }
        }
    }
