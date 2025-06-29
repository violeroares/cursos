package com.rockandcode.cursos.domain.usecases

import com.rockandcode.cursos.domain.repositories.IUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class IsCoursePurchasedUseCase(
    private val userRepository: IUserRepository,
) {
    operator fun invoke(courseId: Int): Flow<Boolean> =
        userRepository.currentUser.map { user ->
            user?.purchasedCourses?.any { it.id == courseId } == true
        }
}
