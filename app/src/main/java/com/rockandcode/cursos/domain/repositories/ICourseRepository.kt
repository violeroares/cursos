package com.rockandcode.cursos.domain.repositories

import com.rockandcode.cursos.domain.models.Category
import com.rockandcode.cursos.domain.models.Certificate
import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.models.RangeMedal
import kotlinx.coroutines.flow.Flow

interface ICourseRepository {
    fun getCourses(): Flow<List<Course>>

    fun getCourseById(id: Int): Flow<Course?>

    fun getMostBoughtCourses(): Flow<List<Course>>

    fun getBestRatedCourses(): Flow<List<Course>>

    fun getAllCategories(): Flow<List<Category>>

    fun getAllMedals(): Flow<List<RangeMedal>>

    suspend fun getCertificateForCourse(
        userId: Int,
        courseId: Int,
    ): Certificate?
}
