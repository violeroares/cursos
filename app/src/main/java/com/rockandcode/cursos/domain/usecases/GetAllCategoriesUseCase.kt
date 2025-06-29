package com.rockandcode.cursos.domain.usecases

import com.rockandcode.cursos.domain.models.Category
import com.rockandcode.cursos.domain.repositories.ICourseRepository
import kotlinx.coroutines.flow.Flow

class GetAllCategoriesUseCase(
    private val repo: ICourseRepository,
) {
    operator fun invoke(): Flow<List<Category>> = repo.getAllCategories()
}
