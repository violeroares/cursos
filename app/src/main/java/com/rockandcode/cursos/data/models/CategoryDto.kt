package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.Category

data class CategoryDto(
    val id: Int,
    val name: String,
    val imageUrl: String,
) {
    fun toDomain() = Category(id, name, imageUrl)
}
