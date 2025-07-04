package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.Comment

data class CommentDto(
    val id: Int,
    val userName: String,
    val avatarUrl: String,
    val text: String,
    val rating: Int,
    val date: String,
) {
    fun toDomain() = Comment(id, userName, avatarUrl, text, rating, date)
}
