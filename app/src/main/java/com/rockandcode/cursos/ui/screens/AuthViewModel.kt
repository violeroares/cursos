package com.rockandcode.cursos.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel
    @Inject
    constructor() : ViewModel() {
        private val _isAuthenticated = mutableStateOf(false)
        val isAuthenticated: State<Boolean> = _isAuthenticated

        fun login(
            email: String,
            password: String,
        ) {
            if (email.isNotBlank() && password.isNotBlank()) {
                _isAuthenticated.value = true
            }
        }

        fun logout() {
            _isAuthenticated.value = false
        }
    }
