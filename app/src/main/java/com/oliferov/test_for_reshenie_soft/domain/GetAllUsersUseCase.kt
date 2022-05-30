package com.oliferov.test_for_reshenie_soft.domain

class GetAllUsersUseCase(private val repository: UserFieldRepository) {
    operator fun invoke() = repository.getAllUsers()
}