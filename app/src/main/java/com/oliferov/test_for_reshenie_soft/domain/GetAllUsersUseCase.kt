package com.oliferov.test_for_reshenie_soft.domain

import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(private val repository: UserPostsRepository) {
    suspend operator fun invoke() = repository.getAllUsers()
}