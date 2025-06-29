package com.rockandcode.cursos.di

import com.rockandcode.cursos.data.repositories.CourseRepositoryMock
import com.rockandcode.cursos.data.repositories.UserRepositoryMock
import com.rockandcode.cursos.domain.repositories.ICourseRepository
import com.rockandcode.cursos.domain.repositories.IUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MockModule {
    @Provides
    @Singleton
    fun provideCourseRepository(): ICourseRepository = CourseRepositoryMock()

    @Provides
    @Singleton
    fun provideUserRepository(): IUserRepository = UserRepositoryMock()
}
