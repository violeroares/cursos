package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.VideoItem

data class VideoItemDto(
    val id: Int,
    val title: String,
    val description: String,
    val durationSeconds: Int,
    val videoUrl: String,
    val isPreview: Boolean = false,
    val order: Int = 0,
) {
    fun toDomain() = VideoItem(id, title, description, durationSeconds, videoUrl, isPreview, order)
}
