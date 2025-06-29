package com.rockandcode.cursos.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.models.UserCourseProgress
import com.rockandcode.cursos.domain.usecases.GetCourseByIdUseCase
import com.rockandcode.cursos.domain.usecases.GetUserCourseProgressUseCase
import com.rockandcode.cursos.domain.usecases.IsCoursePurchasedUseCase
import com.rockandcode.cursos.domain.usecases.ToggleVideoWatchedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface CourseDetailUiState {
    data object Loading : CourseDetailUiState

    data class Success(
        val course: Course,
        val isPurchased: Boolean,
        val userProgress: UserCourseProgress?,
    ) : CourseDetailUiState

    data class Error(
        val message: String,
    ) : CourseDetailUiState
}

data class CourseDetailState(
    val uiState: CourseDetailUiState,
    val isRefreshing: Boolean = false,
)

@HiltViewModel
class CourseDetailViewModel
    @Inject
    constructor(
        private val getCourseByIdUseCase: GetCourseByIdUseCase,
        private val getUserCourseProgressUseCase: GetUserCourseProgressUseCase,
        private val isCoursePurchasedUseCase: IsCoursePurchasedUseCase,
        private val toggleVideoWatchedUseCase: ToggleVideoWatchedUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(CourseDetailState(CourseDetailUiState.Loading))
        val uiState: StateFlow<CourseDetailState> = _uiState.asStateFlow()

        fun loadCourse(courseId: Int) {
            viewModelScope.launch {
                getCourseByIdUseCase(courseId)
                    .filterNotNull()
                    .combine(isCoursePurchasedUseCase(courseId)) { course, isPurchased ->
                        course to isPurchased
                    }.combine(getUserCourseProgressUseCase(courseId)) { (course, isPurchased), progress ->
                        CourseDetailUiState.Success(course, isPurchased, progress) as CourseDetailUiState
                    }.onStart { emit(CourseDetailUiState.Loading) }
                    .catch { e -> emit(CourseDetailUiState.Error("Error cargando el curso: ${e.message}")) }
                    .collect { uiState ->
                        _uiState.value = CourseDetailState(uiState)
                    }
            }
        }

        fun toggleWatched(
            courseId: Int,
            videoId: Int,
        ) {
            viewModelScope.launch {
                toggleVideoWatchedUseCase(courseId, videoId)
            }
        }
    }
