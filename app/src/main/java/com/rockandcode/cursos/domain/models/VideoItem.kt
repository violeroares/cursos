package com.rockandcode.cursos.domain.models

data class VideoItem(
    val id: Int,
    val title: String,
    val description: String,
    val durationSeconds: Int,
    val videoUrl: String,
    val isPreview: Boolean = false, // Permite mostrar videos sin compra
    val order: Int = 0,
)
