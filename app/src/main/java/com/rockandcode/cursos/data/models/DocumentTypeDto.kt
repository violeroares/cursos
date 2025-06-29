package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.DocumentType

data class DocumentTypeDto(
    val id: Int,
    val name: String,
    val fileExtension: String?,
) {
    fun toDomain() = DocumentType(id, name, fileExtension)
}
