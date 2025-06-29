package com.rockandcode.cursos.domain.models

data class Course(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val rating: Double,
    val price: Double,
    val instructors: List<Instructor>,
    val categories: List<Category>,
    val schedule: List<Schedule>,
    val totalStudents: Int,
    val items: List<VideoItem>,
    val documents: List<CourseDocument> = emptyList(),
    val level: CourseLevel,
    val includes: List<CourseIncludeItem>,
    val requirements: String,
)
