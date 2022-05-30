package com.oliferov.test_for_reshenie_soft.domain

class GetAllUserNewsUseCase(private val repository: UserFieldRepository) {
    suspend operator fun invoke(uid: Int) = repository.getAllUserNews(uid)
}