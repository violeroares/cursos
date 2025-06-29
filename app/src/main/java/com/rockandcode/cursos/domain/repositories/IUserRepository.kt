package com.rockandcode.cursos.domain.repositories

import com.rockandcode.cursos.domain.models.User
import com.rockandcode.cursos.domain.models.UserCourseProgress
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    val currentUser: Flow<User?>

    suspend fun updateVideoProgress(
        courseId: Int,
        videoId: Int,
        watchedSeconds: Int,
    )

    fun getUserCourseProgress(courseId: Int): Flow<UserCourseProgress?>

    suspend fun toggleWatched(
        courseId: Int,
        videoId: Int,
    )
}
