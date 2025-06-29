package com.rockandcode.cursos.domain.usecases

import com.rockandcode.cursos.domain.repositories.IUserRepository

class UpdateVideoProgressUseCase(
    private val repo: IUserRepository,
) {
    suspend operator fun invoke(
        courseId: Int,
        videoId: Int,
        watchedSeconds: Int,
    ) {
        repo.updateVideoProgress(courseId, videoId, watchedSeconds)
    }
}
