package com.rockandcode.cursos.domain.models

data class CourseLevel(
    val id: Int,
    val name: String, // Ej: "Principiante", "Intermedio", "Avanzado"
    val description: String,
)
