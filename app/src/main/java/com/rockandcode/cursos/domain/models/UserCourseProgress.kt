package com.rockandcode.cursos.domain.models

data class UserCourseProgress(
    val courseId: Int,
    val videoProgress: List<UserProgress>,
) {
    fun percentCompleted(course: Course): Double {
        // Obtener todos los videos del curso desde las secciones
        val allVideos = course.sections.flatMap { it.videos }

        val totalDuration = allVideos.sumOf { it.durationSeconds }

        val watched =
            videoProgress.sumOf { progress ->
                val video = allVideos.find { it.id == progress.videoId }
                progress.watchedSeconds.coerceAtMost(video?.durationSeconds ?: 0)
            }

        return if (totalDuration == 0) 0.0 else watched.toDouble() / totalDuration * 100.0
    }
}
