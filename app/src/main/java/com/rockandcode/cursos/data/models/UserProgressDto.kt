package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.UserProgress

data class UserProgressDto(
    val videoId: Int,
    val watchedSeconds: Int,
) {
    fun toDomain() = UserProgress(videoId, watchedSeconds)
}
