package com.rockandcode.cursos.domain.usecases

import com.rockandcode.cursos.domain.models.Certificate
import com.rockandcode.cursos.domain.repositories.ICourseRepository

class GetCertificateUseCase(
    private val repository: ICourseRepository,
) {
    suspend operator fun invoke(
        userId: Int,
        courseId: Int,
    ): Certificate? = repository.getCertificateForCourse(userId, courseId)
}
