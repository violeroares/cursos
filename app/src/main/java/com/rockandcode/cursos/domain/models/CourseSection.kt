package com.rockandcode.cursos.domain.models

data class CourseSection(
    val id: Int,
    val title: String,
    val description: String,
    val videos: List<VideoItem>,
)
