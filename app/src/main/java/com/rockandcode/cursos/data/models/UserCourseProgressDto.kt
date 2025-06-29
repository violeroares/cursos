package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.UserCourseProgress

data class UserCourseProgressDto(
    val courseId: Int,
    val videoProgress: List<UserProgressDto>,
) {
    fun toDomain() = UserCourseProgress(courseId, videoProgress.map { it.toDomain() })
}
