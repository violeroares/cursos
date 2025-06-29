package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.CourseDocument

data class CourseDocumentDto(
    val id: Int,
    val title: String,
    val description: String,
    val url: String,
    val documentType: DocumentTypeDto,
) {
    fun toDomain() = CourseDocument(id, title, description, url, documentType.toDomain())
}
