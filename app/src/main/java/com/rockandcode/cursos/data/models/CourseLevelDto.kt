package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.CourseLevel

data class CourseLevelDto(
    val id: Int,
    val name: String,
    val description: String,
) {
    fun toDomain() = CourseLevel(id, name, description)
}
