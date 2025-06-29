package com.rockandcode.cursos.domain.usecases

import com.rockandcode.cursos.domain.models.UserCourseProgress
import com.rockandcode.cursos.domain.repositories.IUserRepository
import kotlinx.coroutines.flow.Flow

class GetUserCourseProgressUseCase(
    private val userRepository: IUserRepository,
) {
    operator fun invoke(courseId: Int): Flow<UserCourseProgress?> = userRepository.getUserCourseProgress(courseId)
}
