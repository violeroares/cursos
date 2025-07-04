package com.rockandcode.cursos.domain.models

data class Comment(
    val id: Int,
    val userName: String,
    val avatarUrl: String,
    val text: String,
    val rating: Int,
    val date: String,
)
