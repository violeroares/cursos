package com.rockandcode.cursos.domain.usecases

import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.repositories.ICourseRepository
import kotlinx.coroutines.flow.Flow

class GetMostBoughtCoursesUseCase(
    private val repo: ICourseRepository,
) {
    operator fun invoke(): Flow<List<Course>> = repo.getMostBoughtCourses()
}
