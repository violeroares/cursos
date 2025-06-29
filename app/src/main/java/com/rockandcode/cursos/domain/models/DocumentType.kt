package com.rockandcode.cursos.domain.models

data class DocumentType(
    val id: Int,
    val name: String, // Ej: "PDF", "Word", "Ejercicio", etc (para mostrar texto)
    val fileExtension: String?, // Ej: "pdf", "docx", "xlsx", null si es genérico
)
