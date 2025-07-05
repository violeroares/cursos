package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.models.CourseFeatureItem
import com.rockandcode.cursos.domain.models.FeatureType

data class CourseDto(
    val id: Int,
    val title: String,
    val subTitle: String,
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
    val sections: List<CourseSectionDto>,
    val documents: List<CourseDocumentDto> = emptyList(),
    val level: CourseLevelDto,
    val features: List<CourseFeatureItemDto>,
    val requirements: List<String> = emptyList(),
    val author: InstructorDto,
    val createdAt: String,
    val updatedAt: String,
    val topics: List<String> = emptyList(),
    val tags: List<String> = emptyList(),
    val comments: List<CommentDto>,
    val hasCertificate: Boolean,
    val hasLifetimeAccess: Boolean,
) {
    fun toDomain() =
        Course(
            id,
            title,
            subTitle = subTitle,
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
            sections.map { it.toDomain() },
            documents.map { it.toDomain() },
            level = level.toDomain(),
            features =
                features.map {
                    CourseFeatureItem(
                        featureType =
                            FeatureType(
                                id = it.featureType.id,
                                name = it.featureType.name,
                                iconKey = it.featureType.iconKey,
                                showValue = it.featureType.showValue,
                                unitLabel = it.featureType.unitLabel,
                                displayOrder = it.featureType.displayOrder,
                            ),
                        value = it.value,
                    )
                },
            requirements = requirements,
            author = instructors.firstOrNull()?.toDomain(),
            createdAt = createdAt,
            updatedAt = updatedAt,
            topics = topics,
            tags = tags,
            comments.map { it.toDomain() },
            hasCertificate = hasCertificate,
            hasLifetimeAccess = hasLifetimeAccess,
        )
}
