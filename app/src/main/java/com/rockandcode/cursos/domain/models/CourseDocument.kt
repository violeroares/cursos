package com.rockandcode.cursos.domain.models

data class CourseDocument(
    val id: Int,
    val title: String,
    val description: String,
    val url: String,
    val documentType: DocumentType,
)
