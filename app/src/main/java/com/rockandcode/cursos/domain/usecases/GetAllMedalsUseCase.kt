package com.rockandcode.cursos.domain.usecases

import com.rockandcode.cursos.domain.models.RangeMedal
import com.rockandcode.cursos.domain.repositories.ICourseRepository
import kotlinx.coroutines.flow.Flow

class GetAllMedalsUseCase(
    private val repository: ICourseRepository,
) {
    operator fun invoke(): Flow<List<RangeMedal>> = repository.getAllMedals()
}
