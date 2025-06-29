package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.Instructor

data class InstructorDto(
    val id: Int,
    val name: String,
    val avatarUrl: String,
    val bio: String?,
) {
    fun toDomain() = Instructor(id, name, avatarUrl, bio)
}
