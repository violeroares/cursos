package com.rockandcode.cursos.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rockandcode.cursos.domain.models.Instructor
import com.rockandcode.cursos.domain.usecases.GetInstructorByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface InstructorUiState {
    object Loading : InstructorUiState

    data class Success(
        val instructor: Instructor,
    ) : InstructorUiState

    data class Error(
        val message: String,
    ) : InstructorUiState
}

@HiltViewModel
class InstructorViewModel
    @Inject
    constructor(
        private val getInstructorByIdUseCase: GetInstructorByIdUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<InstructorUiState>(InstructorUiState.Loading)
        val uiState: StateFlow<InstructorUiState> = _uiState.asStateFlow()

        fun loadInstructor(id: Int) {
            viewModelScope
                .launch {
                    getInstructorByIdUseCase(id)
                        .onStart {
                            _uiState.value = InstructorUiState.Loading
                        }.catch {
                            _uiState.value = InstructorUiState.Error("Error al cargar el Instructor")
                        }.collect { instructor ->
                            if (instructor != null) {
                                _uiState.value = InstructorUiState.Success(instructor)
                            } else {
                                _uiState.value = InstructorUiState.Error("Instructor no encontrado")
                            }
                        }
                }
        }
    }
