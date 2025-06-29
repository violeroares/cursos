package com.rockandcode.cursos.domain.models

data class Instructor(
    val id: Int,
    val name: String,
    val avatarUrl: String,
    val bio: String?,
    val experience: String?,
    val specialization: String?,
)
