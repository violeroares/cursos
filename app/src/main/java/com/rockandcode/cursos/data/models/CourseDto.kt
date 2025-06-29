package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.Course

data class CourseDto(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val rating: Double,
    val price: Double,
    val instructors: List<InstructorDto>,
    val categories: List<CategoryDto>,
    val schedule: List<ScheduleDto>,
    val totalStudents: Int,
    val items: List<VideoItemDto>,
    val documents: List<CourseDocumentDto> = emptyList(),
    val level: CourseLevelDto,
) {
    fun toDomain() =
        Course(
            id,
            title,
            description,
            thumbnailUrl,
            rating,
            price,
            instructors.map { it.toDomain() },
            categories.map { it.toDomain() },
            schedule.map { it.toDomain() },
            totalStudents,
            items.map { it.toDomain() },
            documents.map { it.toDomain() },
            level = level.toDomain(),
        )
}
