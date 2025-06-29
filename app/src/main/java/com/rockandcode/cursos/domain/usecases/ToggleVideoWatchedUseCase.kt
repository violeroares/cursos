package com.rockandcode.cursos.domain.usecases

import com.rockandcode.cursos.domain.repositories.IUserRepository

class ToggleVideoWatchedUseCase(
    private val userRepository: IUserRepository,
) {
    suspend operator fun invoke(
        courseId: Int,
        videoId: Int,
    ) {
        userRepository.toggleWatched(courseId, videoId)
    }
}
