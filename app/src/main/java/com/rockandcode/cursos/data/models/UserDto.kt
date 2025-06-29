package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.User

data class UserDto(
    val id: Int,
    val name: String,
    val email: String,
    val avatarUrl: String,
    val purchasedCourses: List<CourseDto>,
    val progressByCourse: List<UserCourseProgressDto>,
    val score: Int,
    val preferredCategories: List<CategoryDto>,
) {
    fun toDomain() =
        User(
            id,
            name,
            email,
            avatarUrl,
            purchasedCourses.map { it.toDomain() },
            progressByCourse.map { it.toDomain() },
            score,
            preferredCategories.map { it.toDomain() },
        )
}
