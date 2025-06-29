package com.rockandcode.cursos.di

import com.rockandcode.cursos.domain.repositories.ICourseRepository
import com.rockandcode.cursos.domain.repositories.IUserRepository
import com.rockandcode.cursos.domain.usecases.GetAllCategoriesUseCase
import com.rockandcode.cursos.domain.usecases.GetAllMedalsUseCase
import com.rockandcode.cursos.domain.usecases.GetBestRatedCoursesUseCase
import com.rockandcode.cursos.domain.usecases.GetCourseByIdUseCase
import com.rockandcode.cursos.domain.usecases.GetCurrentUserUseCase
import com.rockandcode.cursos.domain.usecases.GetMostBoughtCoursesUseCase
import com.rockandcode.cursos.domain.usecases.GetUserCourseProgressUseCase
import com.rockandcode.cursos.domain.usecases.IsCoursePurchasedUseCase
import com.rockandcode.cursos.domain.usecases.ToggleVideoWatchedUseCase
import com.rockandcode.cursos.domain.usecases.UpdateVideoProgressUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetCurrentUserUseCase(userRepository: IUserRepository): GetCurrentUserUseCase = GetCurrentUserUseCase(userRepository)

    @Provides
    fun provideGetMostBoughtCoursesUseCase(courseRepository: ICourseRepository): GetMostBoughtCoursesUseCase =
        GetMostBoughtCoursesUseCase(courseRepository)

    @Provides
    fun provideGetBestRatedCoursesUseCase(courseRepository: ICourseRepository): GetBestRatedCoursesUseCase =
        GetBestRatedCoursesUseCase(courseRepository)

    @Provides
    fun provideGetAllCategoriesUseCase(courseRepository: ICourseRepository): GetAllCategoriesUseCase =
        GetAllCategoriesUseCase(courseRepository)

    @Provides
    fun provideGetCourseByIdUseCase(courseRepository: ICourseRepository): GetCourseByIdUseCase = GetCourseByIdUseCase(courseRepository)

    @Provides
    fun provideUpdateVideoProgressUseCase(userRepository: IUserRepository): UpdateVideoProgressUseCase =
        UpdateVideoProgressUseCase(userRepository)

    @Provides
    fun provideGetAllMedalsUseCase(courseRepository: ICourseRepository): GetAllMedalsUseCase = GetAllMedalsUseCase(courseRepository)

    @Provides
    fun provideGetUserCourseProgressUseCase(userRepository: IUserRepository): GetUserCourseProgressUseCase =
        GetUserCourseProgressUseCase(userRepository)

    @Provides
    fun provideIsCoursePurchasedUseCase(userRepository: IUserRepository): IsCoursePurchasedUseCase =
        IsCoursePurchasedUseCase(userRepository)

    @Provides
    fun provideToggleVideoWatchedUseCase(userRepository: IUserRepository): ToggleVideoWatchedUseCase =
        ToggleVideoWatchedUseCase(userRepository)
}
