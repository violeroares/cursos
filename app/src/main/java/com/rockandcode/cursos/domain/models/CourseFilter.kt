package com.rockandcode.cursos.domain.models

data class CourseFilter(
    val categoryId: Int? = null,
    val minDuration: Int? = null,
    val maxDuration: Int? = null,
)
