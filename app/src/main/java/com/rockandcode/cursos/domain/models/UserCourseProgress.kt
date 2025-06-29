package com.rockandcode.cursos.domain.models

data class UserCourseProgress(
    val courseId: Int,
    val videoProgress: List<UserProgress>,
) {
//    fun percentCompleted(course: Course): Double {
//        val totalDuration = course.items.sumOf { it.durationSeconds }
//        val watched =
//            videoProgress.sumOf {
//                it.watchedSeconds.coerceAtMost(course.items.find { v -> v.id == it.videoId }?.durationSeconds ?: 0)
//            }
//        return if (totalDuration == 0) 0.0 else watched.toDouble() / totalDuration.toDouble() * 100.0
//    }
}
