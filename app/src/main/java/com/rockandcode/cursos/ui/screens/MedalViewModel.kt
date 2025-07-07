package com.rockandcode.cursos.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rockandcode.cursos.domain.models.RangeMedal
import com.rockandcode.cursos.domain.usecases.GetAllMedalsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface MedalUiState {
    object Loading : MedalUiState

    data class Success(
        val medals: List<RangeMedal>,
    ) : MedalUiState

    data class Error(
        val message: String,
    ) : MedalUiState
}

@HiltViewModel
class MedalViewModel
    @Inject
    constructor(
        private val getAllMedalsUseCase: GetAllMedalsUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<MedalUiState>(MedalUiState.Loading)
        val uiState: StateFlow<MedalUiState> = _uiState.asStateFlow()

        init {
            loadMedals()
        }

        fun loadMedals() {
            viewModelScope
                .launch {
                    getAllMedalsUseCase()
                        .onStart {
                            _uiState.value = MedalUiState.Loading
                        }.catch {
                            _uiState.value = MedalUiState.Error("Error al cargar el Home")
                        }.collect { medals ->
                            _uiState.value = MedalUiState.Success(medals)
                        }
                }
        }
    }
