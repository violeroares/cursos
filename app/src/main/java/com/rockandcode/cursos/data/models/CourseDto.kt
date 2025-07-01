package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.models.CourseIncludeItem
import com.rockandcode.cursos.domain.models.IncludeType

data class CourseDto(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val rating: Double,
    val ratingCount: Int = 0,
    val price: Double,
    val isFree: Boolean,
    val instructors: List<InstructorDto>,
    val categories: List<CategoryDto>,
    val schedule: List<ScheduleDto>,
    val totalStudents: Int,
    val items: List<VideoItemDto>,
    val documents: List<CourseDocumentDto> = emptyList(),
    val level: CourseLevelDto,
    val includes: List<CourseIncludeItemDto>,
    val requirements: String,
    val createdAt: String,
    val updatedAt: String,
    val topics: List<String> = emptyList(),
    val tags: List<String> = emptyList(),
) {
    fun toDomain() =
        Course(
            id,
            title,
            description,
            thumbnailUrl,
            rating,
            ratingCount = ratingCount,
            price,
            isFree = isFree,
            instructors.map { it.toDomain() },
            categories.map { it.toDomain() },
            schedule.map { it.toDomain() },
            totalStudents,
            items.map { it.toDomain() },
            documents.map { it.toDomain() },
            level = level.toDomain(),
            includes =
                includes.map {
                    CourseIncludeItem(
                        type =
                            IncludeType(
                                id = it.type.id,
                                name = it.type.name,
                                iconUrl = it.type.iconUrl,
                            ),
                        description = it.description,
                    )
                },
            requirements = requirements,
            author = instructors.firstOrNull()?.toDomain(),
            createdAt = createdAt,
            updatedAt = updatedAt,
            topics = topics,
            tags = tags,
        )
}
