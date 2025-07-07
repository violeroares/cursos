package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.CourseSection

data class CourseSectionDto(
    val id: Int,
    val title: String,
    val description: String,
    val videos: List<VideoItemDto>,
) {
    fun toDomain() = CourseSection(id, title, description, videos = this.videos.map { it.toDomain() })
}
