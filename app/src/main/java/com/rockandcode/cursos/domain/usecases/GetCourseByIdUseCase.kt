package com.rockandcode.cursos.domain.usecases

import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.repositories.ICourseRepository
import kotlinx.coroutines.flow.Flow

class GetCourseByIdUseCase(
    private val repo: ICourseRepository,
) {
    operator fun invoke(id: Int): Flow<Course?> = repo.getCourseById(id)
}
