package com.rockandcode.cursos.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rockandcode.cursos.domain.models.Category
import com.rockandcode.cursos.domain.usecases.GetAllCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FiltersViewModel
    @Inject
    constructor(
        private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    ) : ViewModel() {
        private val _categories = MutableStateFlow<List<Category>>(emptyList())
        val categories: StateFlow<List<Category>> = _categories

        init {
            viewModelScope.launch {
                getAllCategoriesUseCase()
                    .collectLatest { categoryList ->
                        _categories.value = categoryList
                    }
            }
        }
    }
