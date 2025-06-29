package com.rockandcode.cursos.domain.usecases

import com.rockandcode.cursos.domain.models.User
import com.rockandcode.cursos.domain.repositories.IUserRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentUserUseCase(
    private val repo: IUserRepository,
) {
    operator fun invoke(): Flow<User?> = repo.currentUser
}
