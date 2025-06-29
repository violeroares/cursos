package com.rockandcode.cursos.data.repositories

import com.rockandcode.cursos.data.datasources.local.MockDataSource
import com.rockandcode.cursos.data.models.UserProgressDto
import com.rockandcode.cursos.domain.models.User
import com.rockandcode.cursos.domain.models.UserCourseProgress
import com.rockandcode.cursos.domain.repositories.IUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class UserRepositoryMock : IUserRepository {
    // Emitimos el usuario actual como Flow usando MutableStateFlow
    private val _currentUser = MutableStateFlow(MockDataSource.userDto.toDomain())
    override val currentUser: Flow<User?> = _currentUser.asStateFlow()

    // Actualiza el progreso de un video en un curso específico
    override suspend fun updateVideoProgress(
        courseId: Int,
        videoId: Int,
        watchedSeconds: Int,
    ) {
        // Actualizamos la data mutable en MockDataSource
        val progressList = MockDataSource.pprogressByCourse.getOrPut(courseId) { mutableListOf() }
        val videoIndex = progressList.indexOfFirst { it.videoId == videoId }

        if (videoIndex == -1) {
            // No existe progreso para ese video, agregamos
            progressList.add(UserProgressDto(videoId, watchedSeconds))
        } else {
            // Actualizamos solo si el nuevo tiempo es mayor
            val currentWatched = progressList[videoIndex].watchedSeconds
            if (watchedSeconds > currentWatched) {
                progressList[videoIndex] = UserProgressDto(videoId, watchedSeconds)
            }
        }

        // Sincronizamos userDto en MockDataSource
        MockDataSource.syncUserProgress()

        // Emitimos la nueva versión del usuario domain
        _currentUser.value = MockDataSource.userDto.toDomain()
    }

    // Devuelve un Flow con el progreso de un curso específico
    override fun getUserCourseProgress(courseId: Int): Flow<UserCourseProgress?> =
        currentUser.map { user ->
            user?.progressByCourse?.find { it.courseId == courseId }
        }

    // Toggle el video visto: si está marcado, lo desmarca y viceversa
    override suspend fun toggleWatched(
        courseId: Int,
        videoId: Int,
    ) {
        MockDataSource.toggleVideoWatched(courseId, videoId)
        // Luego actualizamos el flujo del usuario para reflejar los cambios
        _currentUser.value = MockDataSource.userDto.toDomain()
    }
}
