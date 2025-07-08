package com.rockandcode.cursos.domain.usecases

import com.rockandcode.cursos.domain.models.Instructor
import com.rockandcode.cursos.domain.repositories.ICourseRepository
import kotlinx.coroutines.flow.Flow

class GetInstructorByIdUseCase(
    private val repo: ICourseRepository,
) {
    operator fun invoke(id: Int): Flow<Instructor?> = repo.getInstructorById(id)
}
