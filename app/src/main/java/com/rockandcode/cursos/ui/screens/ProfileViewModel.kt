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

sealed interface ProfileUiState {
    object Loading : ProfileUiState

    data class Success(
        val user: User,
        val allMedals: List<RangeMedal>,
    ) : ProfileUiState

    data class Error(
        val message: String,
    ) : ProfileUiState
}

@HiltViewModel
class ProfileViewModel
    @Inject
    constructor(
        private val getCurrentUserUseCase: GetCurrentUserUseCase,
        private val getAllMedalsUseCase: GetAllMedalsUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
        val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

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
                        ProfileUiState.Error("No se pudo obtener el usuario")
                    } else {
                        ProfileUiState.Success(user, allMedals)
                    }
                }.catch { e ->
                    _uiState.value = ProfileUiState.Error("Error al cargar perfil: ${e.message}")
                }.collect { result ->
                    _uiState.value = result
                }
            }
        }
    }
