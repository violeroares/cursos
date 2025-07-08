package com.rockandcode.cursos.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rockandcode.cursos.domain.models.User
import com.rockandcode.cursos.domain.usecases.GetCurrentUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class ForgotPasswordUiState {
    object Loading : ForgotPasswordUiState()

    data class Success(
        val user: User,
        val email: String,
    ) : ForgotPasswordUiState()

    data class Error(
        val message: String,
    ) : ForgotPasswordUiState()
}

@HiltViewModel
class ForgotPasswordViewModel
    @Inject
    constructor(
        private val getCurrentUserUseCase: GetCurrentUserUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<ForgotPasswordUiState>(ForgotPasswordUiState.Loading)
        val uiState: StateFlow<ForgotPasswordUiState> = _uiState.asStateFlow()

        init {
            loadProfile()
        }

        private fun loadProfile() {
            viewModelScope.launch {
                getCurrentUserUseCase()
                    .catch { e ->
                        _uiState.value = ForgotPasswordUiState.Error("Error al cargar perfil: ${e.message}")
                    }.collect { user ->
                        if (user == null) {
                            _uiState.value = ForgotPasswordUiState.Error("No se pudo obtener el usuario")
                        } else {
                            _uiState.value = ForgotPasswordUiState.Success(user, user.email)
                        }
                    }
            }
        }
    }
