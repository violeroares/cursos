package com.rockandcode.cursos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rockandcode.cursos.domain.models.Category
import com.rockandcode.cursos.domain.models.User
import com.rockandcode.cursos.domain.usecases.GetCurrentUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface ProfileUiState {
    object Loading : ProfileUiState

    data class Success(
        val user: User,
    ) : ProfileUiState

    data class Error(
        val message: String,
    ) : ProfileUiState
}

data class ProfileInfo(
    var name: String = "",
    var email: String = "",
    var phoneNumber: String = "",
    var addressStreet: String = "",
    var addressNumber: String = "",
    var gender: String = "",
    var preferredCategories: List<Category> = emptyList(),
    var birthDate: String = "",
)

@HiltViewModel
class ProfileViewModel
    @Inject
    constructor(
        private val getCurrentUserUseCase: GetCurrentUserUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
        val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

        var profileInfo by mutableStateOf(ProfileInfo())

        init {
            loadProfile()
        }

        private fun loadProfile() {
            viewModelScope.launch {
                getCurrentUserUseCase()
                    .catch { e ->
                        _uiState.value = ProfileUiState.Error("Error al cargar perfil: ${e.message}")
                    }.collect { user ->
                        if (user == null) {
                            _uiState.value = ProfileUiState.Error("No se pudo obtener el usuario")
                        } else {
                            _uiState.value = ProfileUiState.Success(user)
                            profileInfo =
                                ProfileInfo(
                                    name = user.name,
                                    email = user.email,
                                    phoneNumber = user.phoneNumber.orEmpty(),
                                    addressStreet = user.addressStreet.orEmpty(),
                                    addressNumber = user.addressNumber.orEmpty(),
                                    gender = user.gender.orEmpty(),
                                    preferredCategories = user.preferredCategories.orEmpty(),
                                    birthDate = user.birthDate.orEmpty(),
                                )
                        }
                    }
            }
        }
    }
