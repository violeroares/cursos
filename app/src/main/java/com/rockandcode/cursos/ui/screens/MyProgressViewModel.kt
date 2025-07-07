package com.rockandcode.cursos.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rockandcode.cursos.domain.models.RangeMedal
import com.rockandcode.cursos.domain.models.User
import com.rockandcode.cursos.domain.usecases.GetAllMedalsUseCase
import com.rockandcode.cursos.domain.usecases.GetCurrentUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface MyProgressUiState {
    object Loading : MyProgressUiState

    data class Success(
        val user: User,
        val allMedals: List<RangeMedal>,
    ) : MyProgressUiState

    data class Error(
        val message: String,
    ) : MyProgressUiState
}

@HiltViewModel
class MyProgressViewModel
    @Inject
    constructor(
        private val getCurrentUserUseCase: GetCurrentUserUseCase,
        private val getAllMedalsUseCase: GetAllMedalsUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<MyProgressUiState>(MyProgressUiState.Loading)
        val uiState: StateFlow<MyProgressUiState> = _uiState.asStateFlow()

        init {
            loadProfile()
        }

        private fun loadProfile() {
            viewModelScope.launch {
                combine(
                    getCurrentUserUseCase(),
                    getAllMedalsUseCase(),
                ) { user, allMedals ->
                    if (user == null) {
                        MyProgressUiState.Error("No se pudo obtener el usuario")
                    } else {
                        MyProgressUiState.Success(user, allMedals)
                    }
                }.catch { e ->
                    _uiState.value = MyProgressUiState.Error("Error al cargar perfil: ${e.message}")
                }.collect { result ->
                    _uiState.value = result
                }
            }
        }
    }
