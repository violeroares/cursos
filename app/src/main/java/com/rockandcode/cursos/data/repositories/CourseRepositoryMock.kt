package com.rockandcode.cursos.data.repositories

import com.rockandcode.cursos.data.datasources.local.MockDataSource
import com.rockandcode.cursos.domain.models.Category
import com.rockandcode.cursos.domain.models.Certificate
import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.models.Instructor
import com.rockandcode.cursos.domain.models.RangeMedal
import com.rockandcode.cursos.domain.repositories.ICourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CourseRepositoryMock : ICourseRepository {
    override fun getCourses(): Flow<List<Course>> = flowOf(MockDataSource.coursesDto.map { it.toDomain() })

    override fun getCourseById(id: Int): Flow<Course?> = flowOf(MockDataSource.coursesDto.find { it.id == id }?.toDomain())

    override fun getMostBoughtCourses(): Flow<List<Course>> =
        flowOf(MockDataSource.coursesDto.map { it.toDomain() }.sortedByDescending { it.totalStudents })

    override fun getBestRatedCourses(): Flow<List<Course>> =
        flowOf(MockDataSource.coursesDto.map { it.toDomain() }.sortedByDescending { it.rating })

    override fun getAllCategories(): Flow<List<Category>> = flowOf(MockDataSource.categoriesDto.map { it.toDomain() })

    override fun getAllMedals(): Flow<List<RangeMedal>> = flowOf(MockDataSource.medalsDto.map { it.toDomain() })

    override suspend fun getCertificateForCourse(
        userId: Int,
        courseId: Int,
    ): Certificate? =
        MockDataSource.certificates
            .find {
                it.userId == userId && it.courseId == courseId
            }?.toDomain()

    override fun getInstructorById(id: Int): Flow<Instructor?> = flowOf(MockDataSource.instructorsDto.find { it.id == id }?.toDomain())
}
